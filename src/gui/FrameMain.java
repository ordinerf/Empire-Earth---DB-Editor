package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import datmanager.Core;
import datmanager.DatFile;
import datstructure.DatContent;
import datstructure.DatStructure;
import gui.components.JButtonDat;
import gui.components.JButtonRed;
import gui.components.JScrollPaneRed;
import gui.ui.EEScrollBarUI;
import gui.ui.GridBagConstraintsExtended;
import gui.ui.GridBagLayoutExtended;


public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1973882004055163035L;
	/** Text used in the ABOUT dialog */
	public static final String S_ABOUT = "EE - DB Editor\nVersion: 1.1\nCreated by Forlins & the EE Heaven community   \nGNU General Public License v3   ";
	/** Icon used in the top-left corner in all frames/dialog */
	public static final ImageIcon IMAGE_ICON = new ImageIcon(FrameMain.class.getResource("EE_Icon.png"));
	/** EE logo used in the frame {@code FrameMain} */
	public static final ImageIcon IMAGE_LOGO = new ImageIcon(FrameMain.class.getResource("EE_Logo_1.png"));
	/** EE-Heaven logo used in the ABOUT dialog */
	public static final ImageIcon IMAGE_EE_HEAVEN_LOGO = new ImageIcon(FrameMain.class.getResource("EE_Logo_2.png"));
	/** After the first load, the load dialog won't enable anymore all files by default */
	public boolean firstLoad = true;

	private final JPanel scrollPanePanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPaneRed(scrollPanePanel);

	/** Initialize */
	{
		JLabel image = new JLabel(IMAGE_LOGO);
		JLabel scrollPaneLabel = new JLabel("Loaded data");
		scrollPaneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel labelContainer = new JPanel();
		labelContainer.add(scrollPaneLabel);
		labelContainer.setOpaque(false);
		JButton dbLoad = new JButtonRed("Load dat file");
		JButton dbInfo = new JButtonRed("About");
		dbLoad.addActionListener(evt -> loadFiles());
		dbInfo.addActionListener(evt -> JOptionPane.showMessageDialog(this, S_ABOUT, "About", JOptionPane.INFORMATION_MESSAGE, IMAGE_EE_HEAVEN_LOGO));
		
		scrollPane.getVerticalScrollBar().setUI(new EEScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new EEScrollBarUI());
		scrollPane.getVerticalScrollBar().setUnitIncrement(6);
		scrollPane.setColumnHeaderView(labelContainer);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setVisible(false);

		scrollPanePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		scrollPanePanel.setOpaque(false);
		scrollPaneLabel.setOpaque(false);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayoutExtended(new int[]{650, 0}, new int[]{247, 50, 50}, new double[]{0, 1.0}, new double[]{1.0, 0.0, 0.0}));
		contentPane.setBackground(Core.UI_COLOR_BACKGROUND);
		contentPane.add(image, new GridBagConstraintsExtended(5, 25, 5, 25, 0, 0));
		contentPane.add(dbLoad, new GridBagConstraintsExtended(10, 25, 5, 25, 0, 1));
		contentPane.add(dbInfo, new GridBagConstraintsExtended(10, 25, 10, 25, 0, 2));
		contentPane.add(scrollPane, new GridBagConstraintsExtended(15, 25, 15, 25, 1, 0, 0, 3));
		
		setBounds(Core.getBounds(this, 650, 0.5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAutoRequestFocus(false);
		setIconImage(IMAGE_ICON.getImage());
		setTitle("Empire Earth - DB Editor");
	}


	public FrameMain () {
		super("Main");
		setVisible(true);
	}

	
	public File selectDirectory(File fromDirectory){
		JFileChooser fileChooser = new JFileChooser(fromDirectory != null ? fromDirectory : new File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileHidingEnabled(false);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("EE \"db\" folder", "*"));
		fileChooser.setDialogTitle("Select the folder which contains the EE dat files");
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		int response = fileChooser.showDialog(null, "Select directory");
		
		if (response == JFileChooser.APPROVE_OPTION) {
			File selectedDirectory = fileChooser.getSelectedFile();
			if (selectedDirectory.exists()){
				return selectedDirectory;
			}
		}
		return null;
	}
	

	
	public void loadFiles(){
		File selectedDirectory = null;
		List<DatFile> allFiles;
		List<Boolean> loaded;
		do{
			selectedDirectory = selectDirectory(selectedDirectory);
			if (selectedDirectory == null){
				return;
			}
			String selectedDirectoryPath = selectedDirectory.getPath();
			allFiles = new ArrayList<>(Core.values.length);
			loaded = new ArrayList<>(allFiles.size());
			for(DatStructure datStructure : Core.values){
				DatFile datFile = new DatFile(selectedDirectoryPath + '\\' + datStructure.getFileName(), datStructure);
				if (datFile.exists()){
					allFiles.add(datFile);
					if (Core.DATA.containsKey(datStructure)){
						loaded.add(true);
					} else {
						loaded.add(false);
					}
				}
			}
			if (allFiles.isEmpty()){
				JOptionPane.showMessageDialog(this, "There's no dat file in this directory!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				break;
			}
		} while (true);
		
		DialogSelectFiles frameFiles = new DialogSelectFiles(this, allFiles, loaded, firstLoad);
		List<DatFile> files = frameFiles.getFilesToLoad();
		if (files == null || files.isEmpty()){
			return;
		}

		Core.loadFiles(this, files, (data) -> {
			firstLoad = false;
			Core.DATA.putAll(data);
			int gridRows = Math.max(10, files.size());
			scrollPanePanel.setLayout(new GridLayout(gridRows, 1, 10, 10));
			ArrayList<DatContent> datContents = new ArrayList<>(data.values());
			datContents.sort(null);
			for (DatContent datContent : datContents){
				scrollPanePanel.add(new JButtonDat(this, datContent));
			}
			scrollPane.setVisible(true);
			scrollPanePanel.revalidate();
			setBounds(Core.getBounds(this, 960, 0.65));
		}, ()->{});
	}

}


