package com.Heather;

import javax.swing.*;

/**
 * Created by cryst on 5/4/2016.
 */
public class MusicGui extends JFrame{
    private JPanel rootPanel;


    //new song components
    private JTabbedPane newSongTabbedPane;
    private JTextField songTitleTextBox;
    private JTextField composerTextField;
    private JComboBox formatComboBox;
    private JComboBox styleComboBox;
    private JComboBox genreComboBox;
    private JRadioButton lyricsRadioButton;
    private JTextField instrumentTextField;
    private JRadioButton aboveMiddleCRadioButton;
    private JComboBox keyComboBox;
    private JTextField timeSignatureTextField;
    private JTextField firstPageTextField;
    private JTextField durationTextField;
    private JButton addSongButton;

    //new Book components
    private JTabbedPane newBookTabbedPane;
    private JList bookTitlesJList;
    private JTextField bookTitleTextField;
    private JTextField ISBNTextField;
    private JComboBox bookLocationComboBox;
    private JButton addNewBookButton;

    //new Album components
    private JTabbedPane AlbumTabbedPane;
    private JTextField albumTitleTextField;
    private JTextField artistOrGroupTextField;
    private JComboBox albumLocationComboBox;
    private JList albumTitlesJList;
    private JButton addNewAlbumButton;

    //search components
    private JTabbedPane searchTabbedPane;//search pane
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

    protected MusicGui(){
        setContentPane(rootPanel);
        pack();
        setTitle("Music Inventory");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
