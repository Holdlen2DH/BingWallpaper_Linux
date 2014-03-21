import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BingDsk{

    private int mW = 200;     // with of the middle panel
    private int mH = 150;     // height of th emiddle panel
    private int rlW = 160;
    private int rlH = 120;
    private int yShift = 35;  // Y + yShift
    JFrame f = new JFrame("Bing Desktop");
    JPanel mPanel = new JPanel();
    JPanel rPanel = new JPanel();
    JPanel lPanel = new JPanel();
    // JLable for displaying images
    JLabel mLabel = new JLabel();
    JLabel rLabel = new JLabel();
    JLabel lLabel = new JLabel();
    
    ImageIcon mIcon = new ImageIcon("sheep.jpg");
    ImageIcon rIcon = new ImageIcon("sheep.jpg");
    ImageIcon lIcon = new ImageIcon("sheep.jpg");
    
    // Scale the image if size can't match
    ImageIcon scaleIcon(ImageIcon icon, int pw, int ph){
	int wid = icon.getIconWidth();
	int hei = icon.getIconWidth();
	int pW = 1; int pH = 1;
	pW = pw; pH = ph;
	if(wid > pW || hei > pH){
	    if(wid / pW > hei / pH){
		icon = new ImageIcon(icon.getImage().getScaledInstance(pW, -1, Image.SCALE_DEFAULT));
	    }
	    else{
		icon = new ImageIcon(icon.getImage().getScaledInstance(-1, pH, Image.SCALE_DEFAULT));
	    }
	}
	
	return icon;
	
    }
    void init(){
	mIcon = scaleIcon(mIcon,mW,mH);
	rIcon = scaleIcon(rIcon,rlW,rlH);
	lIcon = scaleIcon(lIcon,rlW,rlH);
	mLabel.setIcon(mIcon); mPanel.add(mLabel);
	rLabel.setIcon(rIcon); rPanel.add(rLabel);
	lLabel.setIcon(lIcon); lPanel.add(lLabel);
	
	//f.setLayout(new BorderLayout(30,5));
	//f.add(mPanel,BorderLayout.CENTER); f.add(rPanel,BorderLayout.EAST); f.add(lPanel,BorderLayout.WEST);
	
	// Can't cross platform
	f.setLayout(null);

	mPanel.setBounds(rlW, yShift, mW, mH);
	rPanel.setBounds((mW + rlW),yShift + (mH - rlH)/2, rlW,rlH);
	lPanel.setBounds(0, yShift +(mH - rlH)/2, rlW, rlH);
	f.add(mPanel); f.add(rPanel); f.add(lPanel);
	f.setSize(mW + 2 * rlW, 2 * yShift + mH);
	//f.add(mLabel); f.add(rLabel); f.add(lLabel);
	//f.setSize(600,400);
	//f.pack();
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
	new BingDsk().init();
	
    }
}
