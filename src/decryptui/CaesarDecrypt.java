package decryptui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import maincode.DecryptAlgorithm;

@SuppressWarnings("serial")
public class CaesarDecrypt extends JPanel 
{
	private JTextField textFieldCipher;
	private JTextField textFieldPlain;
	public CaesarDecrypt() 
	{
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)), "Simple Plain Text", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		
		JLabel lblPlain = new JLabel("Cipher Text:");
		
		textFieldCipher = new JTextField();
		textFieldCipher.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCipher.setToolTipText("Enter Cipher Text Here\r\n");
		textFieldCipher.setColumns(10);
		
		JLabel lblKey = new JLabel("Key");
		
		JSpinner spinnerKey = new JSpinner();
		spinnerKey.setToolTipText("Your Key");
		spinnerKey.setModel(new SpinnerNumberModel(0, 0, 25, 1));
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setToolTipText("DecryptIT");
		
		textFieldPlain = new JTextField();
		textFieldPlain.setEditable(false);
		textFieldPlain.setToolTipText("Plain Text");
		textFieldPlain.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPlain.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("Reset the Message");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldPlain, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPlain, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldCipher, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblKey, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(spinnerKey, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnDecrypt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
									.addGap(350)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlain, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCipher, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKey, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerKey, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDecrypt)
						.addComponent(btnReset))
					.addGap(18)
					.addComponent(textFieldPlain, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldPlain.setText(DecryptAlgorithm.decryptCaesarCipher
						(textFieldCipher.getText(), (int) spinnerKey.getValue()));
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCipher.setText("");
				textFieldPlain.setText("");
				spinnerKey.setValue(0);
			}
		});
	}
}
