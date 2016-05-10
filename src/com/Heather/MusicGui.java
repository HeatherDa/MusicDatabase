package com.Heather;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cryst on 5/4/2016.
 */
public class MusicGui extends JFrame{
    private JPanel rootPanel;
    private JTabbedPane containerTabbedPane;

    //new song components
    private JTabbedPane newSongTabbedPane;
    private JTextField songTitleTextBox;
    private JTextField composerTextField;
    private JComboBox styleComboBox;
    private JComboBox genreComboBox;
    private JRadioButton yesRadioButton;
    private JTextField instrumentTextField;
    private JComboBox keyComboBox;
    private JTextField timeSignatureTextField;
    private JTextField firstPageTextField;
    private JTextField durationTextField;
    private JButton addSongButton;
    private JComboBox formatComboBox;
    private JComboBox lowestComboBox;
    private JComboBox highestComboBox;

    //new Book components
    private JTabbedPane newBookTabbedPane;
    private JList bookTitlesJList;
    private JTextField bookTitleTextField;
    private JTextField ISBNTextField;
    private JComboBox bookLocationComboBox;
    private JButton addNewBookButton;

    //search components
    private JTabbedPane searcherTabbedPane;//search pane
    private JComboBox searchSongTitleComboBox;//optional query parameter
    private JComboBox searchBookTitleComboBox;//optional query parameter
    private JComboBox searchAlbumTitleComboBox;//optional query parameter
    private JComboBox searchComposerComboBox;//optional query parameter
    private JTable searchResultsTable;//shows results of query
    private JComboBox searchKeyComboBox;
    private JButton searchButton;
    private JButton deleteEntryButton;
    private JButton exitButton;
    private JButton editEntryButton;


    protected MusicGui(final SongDataModel songDataModel, final BookDataModel bookDataModel){
        setContentPane(rootPanel);
        pack();
        setTitle("Sheet Music Inventory");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchResultsTable.setGridColor (Color.black);
        searchResultsTable.setModel(songDataModel);


    }
}
