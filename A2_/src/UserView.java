/**
 * 	@author Alma Campos
 * 	CS3560-01
 * 	Assignment 2
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class UserView {

	private User user;
	private JFrame frmUser;
	private JTextField textFieldFollowUser;
	private JTextField textFieldTweet;
	private JList<Subject> listFollowing = new JList<>();
	private JList<String> feed = new JList<>();

	
	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView window = new UserView(user);
					window.frmUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	/**
	 * Create the application.
	 */
	public UserView(User view) {
		user = view;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUser = new JFrame();
		frmUser.setTitle(user.getDisplayName());
		frmUser.setBounds(100, 100, 520, 596);
		frmUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUser.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 89, 468, 170);
		frmUser.getContentPane().add(panel);
		
		
		DefaultListModel<Subject> followersModel = new DefaultListModel<>();
		for (Subject subject : user.getFollowingList()) {
			followersModel.addElement(subject);;
		}
		listFollowing.setModel(followersModel);
		listFollowing.setBorder(new LineBorder(new Color(0, 0, 0)));
		listFollowing.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFollowing.setPreferredSize(new Dimension(460, 160));
		listFollowing.setVisibleRowCount(-1);
		
		panel.add(listFollowing);
		
		textFieldFollowUser = new JTextField();
		textFieldFollowUser.setBounds(125, 16, 209, 27);
		frmUser.getContentPane().add(textFieldFollowUser);
		textFieldFollowUser.setColumns(10);
		
		JButton btnFollow = new JButton("Follow");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User following = new User();
				following.setDisplayName(textFieldFollowUser.getText());
				user.follow(following);
				
				followersModel.addElement(following);
				textFieldFollowUser.setText(null);
				listFollowing = new JList<Subject>(followersModel);
				
			}
		});
		btnFollow.setBounds(349, 15, 115, 29);
		frmUser.getContentPane().add(btnFollow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 309, 468, 170);
		frmUser.getContentPane().add(panel_1);
		
		DefaultListModel<String> newsFeed = new DefaultListModel<>();
		for (String post : user.getNewsFeed()) {
			newsFeed.addElement(post);;
		}
		
		feed.setModel(newsFeed);
		feed.setBorder(new LineBorder(new Color(0, 0, 0)));
		feed.setBackground(Color.WHITE);
		feed.setBorder(new LineBorder(new Color(0, 0, 0)));
		feed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		feed.setPreferredSize(new Dimension(460, 160));
		feed.setVisibleRowCount(-1);
		
		panel_1.add(feed);
		
		textFieldTweet = new JTextField();
		textFieldTweet.setBounds(109, 495, 250, 29);
		frmUser.getContentPane().add(textFieldTweet);
		textFieldTweet.setColumns(10);
		
		JButton btnTweet = new JButton("Tweet");
		btnTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.tweetMessage(textFieldTweet.getText());
				DefaultListModel<String> newsFeed = new DefaultListModel<>();
				for (String post : user.getNewsFeed()) {
					newsFeed.addElement(post);;
				}
				
				feed.setModel(newsFeed);
				textFieldTweet.setText(null);
			}
		});
		btnTweet.setBounds(374, 495, 100, 29);
		frmUser.getContentPane().add(btnTweet);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> newsFeed = new DefaultListModel<>();
				for (String post : user.getNewsFeed()) {
					newsFeed.addElement(post);;
				}
				
				feed.setModel(newsFeed);
			}
		});
		btnRefresh.setBounds(357, 275, 107, 29);
		frmUser.getContentPane().add(btnRefresh);
		
		JLabel lblNewsfeed = new JLabel("Newsfeed");
		lblNewsfeed.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewsfeed.setBounds(25, 274, 100, 29);
		frmUser.getContentPane().add(lblNewsfeed);
		
		JLabel lblFollowing = new JLabel("Following");
		lblFollowing.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFollowing.setBounds(25, 55, 115, 29);
		frmUser.getContentPane().add(lblFollowing);
		
		JLabel lblEnterUser = new JLabel("Enter User:");
		lblEnterUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterUser.setBounds(21, 19, 89, 20);
		frmUser.getContentPane().add(lblEnterUser);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMessage.setBounds(25, 499, 69, 20);
		frmUser.getContentPane().add(lblMessage);
		
	}
		
}
