package Main;
import java.util.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

 

public class View extends JFrame{

	
	private File selectedFile;
	private JTextField textField;
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JFileChooser fileChooser = new JFileChooser();
	private JTextArea jTextArea = new JTextArea();

	

	public View() {

		setTitle("FileTest");
		getContentPane().setLayout(null);
		setBounds(400, 10, 800, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JLabel label = new JLabel();
		final JLabel label1 = new JLabel();
		final JLabel label2 = new JLabel();
		final JLabel label3 = new JLabel();
		final JLabel label4 = new JLabel();
		label.setText("�ļ���");
		label1.setText("�ļ�·����");
		label2.setText("�ļ�����");
		label3.setText("�ļ���С��");
		label4.setText("�ϴ��޸�ʱ�䣺");
		panel.setLayout(null);
		label.setBounds(30,10,60,20);
		panel.add(label);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.setLayout(null);
		label1.setBounds(30,10,350,30);
		label2.setBounds(30,50,350,30);
		label3.setBounds(390,10,350,30);
		label4.setBounds(390,50,350,30);
		jTextArea.setText("��ѡ���ļ���");
		jTextArea.setLineWrap(true);
		panel3.setLayout(null);
		JScrollPane scroll = new JScrollPane(jTextArea);
		panel3.add(scroll);
		scroll.setBounds(30,0,700,342);
		jTextArea.setBounds(30,0,700,342);
		
		textField = new JTextField();
		textField.setColumns(20);
		textField.setBounds(65,10,600,20);
		panel.add(textField);
		JButton button_1 = new JButton("\u7EDF\u8BA1\u5173\u952E\u8BCD");
		button_1.setBounds(25, 550, 124, 23);
		getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(159, 554, 166, 15);
		getContentPane().add(lblNewLabel);
		
		final JButton button = new JButton("ѡ��");
		final JButton button1 = new JButton("����");
		final JButton button2 = new JButton("ɾ��");
		button.setBounds(670,10,60,20);
		button1.setBounds(170,352,60,20);
		button2.setBounds(530,352,60,20);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				

				int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���
				
				

				// �ж��û��������Ƿ�Ϊ���򿪡���ť

				if (i == JFileChooser.APPROVE_OPTION) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					selectedFile = fileChooser.getSelectedFile();// ���ѡ�е��ļ�����
					try {
						InputStreamReader ReaderFile=new InputStreamReader(new FileInputStream(selectedFile),"UTF-8");
						char[] a = new char[10000];
						ReaderFile.read(a);
						String str=String.valueOf(a);
						jTextArea.setText(str);
						ReaderFile.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textField.setText(selectedFile.getAbsolutePath());// ��ʾѡ���ļ�������
					label1.setText("�ļ�·����"+selectedFile.getAbsolutePath());
					label2.setText("�ļ�����"+selectedFile.getName());
					label3.setText("�ļ���С��"+selectedFile.length()+"�ֽ�");
					label4.setText("�ϴ��޸�ʱ�䣺"+dateFormat.format(selectedFile.lastModified()));
				}

			}

		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(selectedFile==null)
						jTextArea.setText("����ļ�����ѡ�񱣴棡����");
					else {
					try {
						BufferedWriter WriterFile = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (selectedFile),"UTF-8"));
						System.out.println(jTextArea.getText());
						WriterFile.write(jTextArea.getText());
						WriterFile.flush();
						WriterFile.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}

		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedFile.exists()) {
					selectedFile.delete();
					jTextArea.setText("ɾ���ɹ���");
				}
				else {
					jTextArea.setText("ɾ��ʧ�ܣ�");
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search searchKey = new Search();
				lblNewLabel.setText("Java�ؼ��ֳ�����"+searchKey.SearchKeyword(selectedFile)+"��");
			}
		});
		panel.add(button);
		panel3.add(button1);
		panel3.add(button2);
		getContentPane().add(panel);
		getContentPane().add(panel3);
		getContentPane().add(panel2);
		panel.setBounds(15,10,770,30);
		panel3.setBounds(15,50,770,379);
		panel2.setBounds(25,439,770,80);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(365, 550, 184, 24);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("�������");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search search = new Search();
				String line=jTextArea.getText();
				String pattern=textArea.getText();
				String str=search.Regularsearch(line, pattern);
				jTextArea.setText(str);
			}
		});
		btnNewButton.setBounds(559, 550, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tokenizer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(662, 550, 93, 23);
		getContentPane().add(btnNewButton_1);
		

		setVisible(true);

	}

	

	

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		View test = new View();

 

	}
}
