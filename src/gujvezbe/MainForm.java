/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gujvezbe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import util.MPlayer;

/**
 *
 * @author PreBoosted
 */
public class MainForm extends JFrame {

    private final String allowedSoundKeys = "^(?=.*[a-zA-Z\\d].*)[a-zA-Z\\d!@#$%&*]{7,}$";
    
    Expansion ex = new Expansion();

    int xMouse;
    int yMouse;
    

    
    
    
    private boolean finished = false;
    private boolean finished1 = false;
    private boolean finished2 = false;

    private int locked = 0;
    private int locked1 = 0;
    private int locked2 = 0;
    private int saveClause = 0;

    private boolean task2 = false;
    private boolean task3 = false;

    BufferedWriter writer;

    TaskInfo ti;
    PostIt ps = new PostIt();

    Font font = new Font("MS UI Gothic", 0, 14);
    Font fontBald = new Font("MS UI Gothic", Font.BOLD, 14);

    public MainForm() {

        // main reasons our jframe is transparent 
        this.setUndecorated(true);
        this.setBackground(new Color(0, 255, 0, 0));
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/util/arrobea.png")));
        this.setTitle("task");
        
        initComponents();
        
    }

    private void lockUnlock(JButton jb, JTextField jtf) {
        switch (locked) {

            //lock is off
            case 0:

                jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon.png")));
                jb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon 39.png")));

                jtf.setFocusable(false);
                jtf.setEditable(false);
                jtf.setCaretColor(new Color(9999));

                locked = 1;

                break;

            // lock is on
            case 1:

                jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon.png")));
                jb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon39.png")));

                jtf.setFocusable(true);
                jtf.setEditable(true);
                jtf.setCaretColor(new Color(9999));
                jtf.selectAll();
                jtf.requestFocus();

                locked = 0;

                break;
        }

    }

    private void lockUnlock1(JButton jb, JTextField jtf) {
        switch (locked1) {

            //lock is off
            case 0:

                jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon.png")));
                jb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon 39.png")));

                jtf.setFocusable(false);
                jtf.setEditable(false);
                jtf.setCaretColor(new Color(9999));

                locked1 = 1;

                break;

            // lock is on
            case 1:

                jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon.png")));
                jb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon39.png")));

                jtf.setFocusable(true);
                jtf.setEditable(true);
                jtf.setCaretColor(new Color(9999));
                jtf.selectAll();
                jtf.requestFocus();

                locked1 = 0;

                break;
        }

    }

    private void lockUnlock2(JButton jb, JTextField jtf) {
        switch (locked2) {

            //lock is off
            case 0:

                jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon.png")));
                jb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon 39.png")));

                jtf.setFocusable(false);
                jtf.setEditable(false);
                jtf.setCaretColor(new Color(9999));

                locked2 = 1;

                break;

            // lock is on
            case 1:

                jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon.png")));
                jb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon39.png")));

                jtf.setFocusable(true);
                jtf.setEditable(true);
                jtf.setCaretColor(new Color(9999));
                jtf.selectAll();
                jtf.requestFocus();

                locked2 = 0;

                break;
        }

    }

    private void changeFormState(boolean confirm, JLabel jlb, JTextField jtf, JButton lck, JButton dis, JButton conf) {
        try {
            //setting up background acordingly to first win
            // and making sure text can be read and is not focusable

            if (confirm) {
                jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/tasketClosed.png")));
            } else {
                jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/tasketConfirmed.png")));
            }

            //disabling text field editing
            jtf.setForeground(Color.white);
            jtf.setFont(fontBald);
            jtf.setEditable(false);
            jtf.setFocusable(false);

            //disabling all button effects 
            lck.setRolloverEnabled(false);
            lck.enableInputMethods(false);
            lck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/lock-icon.png")));

            conf.setRolloverEnabled(false);
            conf.enableInputMethods(false);
            dis.setRolloverEnabled(false);
            dis.enableInputMethods(false);

            new MPlayer().clickSound();

        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstTaskField = new javax.swing.JTextField();
        firstLabel = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        redXBtn = new javax.swing.JButton();
        lockBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        dragLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        hiddenTextField2 = new javax.swing.JTextField();
        hiddenTextField1 = new javax.swing.JTextField();
        lockBtn1 = new javax.swing.JButton();
        redXBtn1 = new javax.swing.JButton();
        confirmBtn1 = new javax.swing.JButton();
        lockBtn2 = new javax.swing.JButton();
        redXBtn2 = new javax.swing.JButton();
        confirmBtn2 = new javax.swing.JButton();
        expandBtn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        expansionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        setMinimumSize(new java.awt.Dimension(234, 500));
        setName("Form"); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(234, 500));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstTaskField.setDocument(new Limtator(12));
        firstTaskField.setFont(font);
        firstTaskField.setForeground(new java.awt.Color(0, 0, 0));
        firstTaskField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstTaskField.setAutoscrolls(false);
        firstTaskField.setBorder(null);
        firstTaskField.setCaretColor(new java.awt.Color(0, 0, 51));
        firstTaskField.setName("firstTaskField"); // NOI18N
        firstTaskField.setOpaque(false);
        firstTaskField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstTaskFieldActionPerformed(evt);
            }
        });
        firstTaskField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstTaskFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstTaskFieldKeyReleased(evt);
            }
        });
        getContentPane().add(firstTaskField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 95, 110, 30));

        firstLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/tasketOpen.png"))); // NOI18N
        firstLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        firstLabel.setIconTextGap(0);
        firstLabel.setName("firstLabel"); // NOI18N
        getContentPane().add(firstLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 40));

        confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/check-icon1.png"))); // NOI18N
        confirmBtn.setBorderPainted(false);
        confirmBtn.setContentAreaFilled(false);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setFocusable(false);
        confirmBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        confirmBtn.setMaximumSize(new java.awt.Dimension(32, 32));
        confirmBtn.setMinimumSize(new java.awt.Dimension(32, 32));
        confirmBtn.setName("confirmBtn"); // NOI18N
        confirmBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        confirmBtn.setRequestFocusEnabled(false);
        confirmBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/check-ico24.png"))); // NOI18N
        confirmBtn.setVerifyInputWhenFocusTarget(false);
        confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtnMouseReleased(evt);
            }
        });
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        getContentPane().add(confirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, 24));

        redXBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cross-3-icon.png"))); // NOI18N
        redXBtn.setBorderPainted(false);
        redXBtn.setContentAreaFilled(false);
        redXBtn.setFocusPainted(false);
        redXBtn.setFocusable(false);
        redXBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redXBtn.setMaximumSize(new java.awt.Dimension(32, 32));
        redXBtn.setMinimumSize(new java.awt.Dimension(32, 32));
        redXBtn.setName("redXBtn"); // NOI18N
        redXBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        redXBtn.setRequestFocusEnabled(false);
        redXBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cross-2-icon.png"))); // NOI18N
        redXBtn.setVerifyInputWhenFocusTarget(false);
        redXBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                redXBtnMouseReleased(evt);
            }
        });
        getContentPane().add(redXBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 24, 24));

        lockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon.png"))); // NOI18N
        lockBtn.setBorderPainted(false);
        lockBtn.setContentAreaFilled(false);
        lockBtn.setFocusPainted(false);
        lockBtn.setFocusable(false);
        lockBtn.setName("lockBtn"); // NOI18N
        lockBtn.setRequestFocusEnabled(false);
        lockBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon39.png"))); // NOI18N
        lockBtn.setVerifyInputWhenFocusTarget(false);
        lockBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lockBtnMouseReleased(evt);
            }
        });
        lockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtnActionPerformed(evt);
            }
        });
        getContentPane().add(lockBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 39, 39));

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/playstation-square-dark-icon.png"))); // NOI18N
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setFocusPainted(false);
        exitBtn.setFocusable(false);
        exitBtn.setName("exitBtn"); // NOI18N
        exitBtn.setRolloverEnabled(true);
        exitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/playstation-square-dark-icon39.png"))); // NOI18N
        exitBtn.setVerifyInputWhenFocusTarget(false);
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitBtnMouseReleased(evt);
            }
        });
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 2, 39, 39));

        dragLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/task@textSmaller.png"))); // NOI18N
        dragLabel.setFocusable(false);
        dragLabel.setName("dragLabel"); // NOI18N
        dragLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragLabelMouseDragged(evt);
            }
        });
        dragLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragLabelMousePressed(evt);
            }
        });
        getContentPane().add(dragLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 153, 40));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/green-plus-sign-md.png"))); // NOI18N
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);
        addButton.setFocusable(false);
        addButton.setName("addButton"); // NOI18N
        addButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/green-plus-sign-md39.png"))); // NOI18N
        addButton.setVerifyInputWhenFocusTarget(false);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 40, 40));

        hiddenTextField2.setDocument(new Limtator(12));
        hiddenTextField2.setFont(font);
        hiddenTextField2.setForeground(new java.awt.Color(0, 0, 0));
        hiddenTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hiddenTextField2.setBorder(null);
        hiddenTextField2.setFocusable(false);
        hiddenTextField2.setName("hiddenTextField2"); // NOI18N
        hiddenTextField2.setOpaque(false);
        hiddenTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiddenTextField2ActionPerformed(evt);
            }
        });
        hiddenTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hiddenTextField2KeyPressed(evt);
            }
        });
        getContentPane().add(hiddenTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 110, 30));

        hiddenTextField1.setDocument(new Limtator(12));
        hiddenTextField1.setFont(font);
        hiddenTextField1.setForeground(new java.awt.Color(0, 0, 0));
        hiddenTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hiddenTextField1.setBorder(null);
        hiddenTextField1.setFocusable(false);
        hiddenTextField1.setName("hiddenTextField1"); // NOI18N
        hiddenTextField1.setOpaque(false);
        hiddenTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hiddenTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(hiddenTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 110, 30));

        lockBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon.png"))); // NOI18N
        lockBtn1.setBorderPainted(false);
        lockBtn1.setContentAreaFilled(false);
        lockBtn1.setFocusPainted(false);
        lockBtn1.setName("lockBtn1"); // NOI18N
        lockBtn1.setRequestFocusEnabled(false);
        lockBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon39.png"))); // NOI18N
        lockBtn1.setVerifyInputWhenFocusTarget(false);
        lockBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lockBtn1MouseReleased(evt);
            }
        });
        lockBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(lockBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 165, 39, 39));

        redXBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cross-3-icon.png"))); // NOI18N
        redXBtn1.setBorderPainted(false);
        redXBtn1.setContentAreaFilled(false);
        redXBtn1.setFocusPainted(false);
        redXBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redXBtn1.setMaximumSize(new java.awt.Dimension(32, 32));
        redXBtn1.setMinimumSize(new java.awt.Dimension(32, 32));
        redXBtn1.setName("redXBtn1"); // NOI18N
        redXBtn1.setPreferredSize(new java.awt.Dimension(32, 32));
        redXBtn1.setRequestFocusEnabled(false);
        redXBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cross-2-icon.png"))); // NOI18N
        redXBtn1.setVerifyInputWhenFocusTarget(false);
        redXBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                redXBtn1MouseReleased(evt);
            }
        });
        getContentPane().add(redXBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 135, 24, 24));

        confirmBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/check-icon1.png"))); // NOI18N
        confirmBtn1.setBorderPainted(false);
        confirmBtn1.setContentAreaFilled(false);
        confirmBtn1.setFocusPainted(false);
        confirmBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        confirmBtn1.setMaximumSize(new java.awt.Dimension(32, 32));
        confirmBtn1.setMinimumSize(new java.awt.Dimension(32, 32));
        confirmBtn1.setName("confirmBtn1"); // NOI18N
        confirmBtn1.setPreferredSize(new java.awt.Dimension(32, 32));
        confirmBtn1.setRequestFocusEnabled(false);
        confirmBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/check-ico24.png"))); // NOI18N
        confirmBtn1.setVerifyInputWhenFocusTarget(false);
        confirmBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtn1MouseReleased(evt);
            }
        });
        getContentPane().add(confirmBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 136, -1, 24));

        lockBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon.png"))); // NOI18N
        lockBtn2.setBorderPainted(false);
        lockBtn2.setContentAreaFilled(false);
        lockBtn2.setFocusPainted(false);
        lockBtn2.setName("lockBtn2"); // NOI18N
        lockBtn2.setRequestFocusEnabled(false);
        lockBtn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/unlock-icon39.png"))); // NOI18N
        lockBtn2.setVerifyInputWhenFocusTarget(false);
        lockBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lockBtn2MouseReleased(evt);
            }
        });
        lockBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(lockBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 245, 39, 39));

        redXBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cross-3-icon.png"))); // NOI18N
        redXBtn2.setBorderPainted(false);
        redXBtn2.setContentAreaFilled(false);
        redXBtn2.setFocusPainted(false);
        redXBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redXBtn2.setMaximumSize(new java.awt.Dimension(32, 32));
        redXBtn2.setMinimumSize(new java.awt.Dimension(32, 32));
        redXBtn2.setName("redXBtn2"); // NOI18N
        redXBtn2.setPreferredSize(new java.awt.Dimension(32, 32));
        redXBtn2.setRequestFocusEnabled(false);
        redXBtn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cross-2-icon.png"))); // NOI18N
        redXBtn2.setVerifyInputWhenFocusTarget(false);
        redXBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                redXBtn2MouseReleased(evt);
            }
        });
        getContentPane().add(redXBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 215, 24, 24));

        confirmBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/check-icon1.png"))); // NOI18N
        confirmBtn2.setBorderPainted(false);
        confirmBtn2.setContentAreaFilled(false);
        confirmBtn2.setFocusPainted(false);
        confirmBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        confirmBtn2.setMaximumSize(new java.awt.Dimension(32, 32));
        confirmBtn2.setMinimumSize(new java.awt.Dimension(32, 32));
        confirmBtn2.setName("confirmBtn2"); // NOI18N
        confirmBtn2.setPreferredSize(new java.awt.Dimension(32, 32));
        confirmBtn2.setRequestFocusEnabled(false);
        confirmBtn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/check-ico24.png"))); // NOI18N
        confirmBtn2.setVerifyInputWhenFocusTarget(false);
        confirmBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtn2MouseReleased(evt);
            }
        });
        getContentPane().add(confirmBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 216, -1, 24));

        expandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/arrowSmaller32.pdf.png"))); // NOI18N
        expandBtn.setBorderPainted(false);
        expandBtn.setContentAreaFilled(false);
        expandBtn.setFocusPainted(false);
        expandBtn.setName("expandBtn"); // NOI18N
        expandBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/arrowbigger32.pdf.png"))); // NOI18N
        expandBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                expandBtnMouseReleased(evt);
            }
        });
        expandBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expandBtnActionPerformed(evt);
            }
        });
        getContentPane().add(expandBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 34, 34));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/tasketOpen.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setIconTextGap(0);
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 164, 130, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/tasketOpen.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 244, 130, 40));

        backGround.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/tasketBranding 1white.png"))); // NOI18N
        backGround.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backGround.setFocusTraversalPolicyProvider(true);
        backGround.setFocusable(false);
        backGround.setName("backGround"); // NOI18N
        backGround.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backGroundKeyPressed(evt);
            }
        });
        getContentPane().add(backGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gujvezbe/Untitled-4unhovered.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setEnabled(false);
        jToggleButton1.setFocusable(false);
        jToggleButton1.setName("jToggleButton1"); // NOI18N
        jToggleButton1.setRolloverEnabled(true);
        jToggleButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gujvezbe/Untitled-4.png"))); // NOI18N
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseReleased(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 370, 42, 42));

        expansionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/expansion.png"))); // NOI18N
        expansionLabel.setName("expansionLabel"); // NOI18N
        getContentPane().add(expansionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 350, 50, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backGroundKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backGroundKeyPressed

    }//GEN-LAST:event_backGroundKeyPressed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed

    }//GEN-LAST:event_exitBtnActionPerformed

    private void lockBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lockBtnMouseReleased
        if (!finished) {

            try {
                new MPlayer().clickSound();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            lockUnlock(lockBtn, firstTaskField);
        }


    }//GEN-LAST:event_lockBtnMouseReleased

    private void confirmBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseReleased
        if (!finished) {
            // all confirmation logic
            // we should add a cute checkbox are you sure etc.
            changeFormState(false, firstLabel, firstTaskField, lockBtn, redXBtn, confirmBtn);
            finished = true;

        }
    }//GEN-LAST:event_confirmBtnMouseReleased

    private void redXBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redXBtnMouseReleased
        if (!finished) {
            // all confirmation logic
            // we should add a cute checkbox are you sure etc.

            changeFormState(true, firstLabel, firstTaskField, lockBtn, redXBtn, confirmBtn);
            finished = true;
        }
    }//GEN-LAST:event_redXBtnMouseReleased

    private void exitBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseReleased

        saveClause = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Close?", JOptionPane.YES_NO_OPTION);

        try {

            new MPlayer().exitSound();
            Thread.sleep(250);

            if (saveClause == JOptionPane.YES_OPTION) {
                saveInputs();
            }
            System.exit(0);
        } catch (InterruptedException | IOException exe) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, exe);
        }
    }//GEN-LAST:event_exitBtnMouseReleased

    private void firstTaskFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstTaskFieldKeyPressed

        if (evt.getKeyCode() == 10) {
            try {

                lockUnlock(lockBtn, firstTaskField);

                locked = 1;

                new MPlayer().typing2Sound();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyChar() > 32 && evt.getKeyChar() < 126) {
            try {

                new MPlayer().typing4Sound();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }

        }

    }//GEN-LAST:event_firstTaskFieldKeyPressed

    private void dragLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragLabelMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse - 80, y - yMouse);

        //ex.setLocation(this.getX() - 37, this.getY() + 352);

    }//GEN-LAST:event_dragLabelMouseDragged

    private void dragLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragLabelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragLabelMousePressed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed


    }//GEN-LAST:event_addButtonActionPerformed

    private void lockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lockBtnActionPerformed

    private void hiddenTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiddenTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hiddenTextField2ActionPerformed

    private void lockBtn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lockBtn1MouseReleased
        if (!finished1) {

            try {
                new MPlayer().clickSound();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            lockUnlock1(lockBtn1, hiddenTextField1);
        }
    }//GEN-LAST:event_lockBtn1MouseReleased

    private void lockBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtn1ActionPerformed

    }//GEN-LAST:event_lockBtn1ActionPerformed

    private void redXBtn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redXBtn1MouseReleased
        if (!finished1) {
            // all confirmation logic
            // we should add a cute checkbox are you sure etc.
            changeFormState(true, jLabel1, hiddenTextField1, lockBtn1, redXBtn1, confirmBtn1);
            finished1 = true;

        }
    }//GEN-LAST:event_redXBtn1MouseReleased

    private void confirmBtn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtn1MouseReleased
        if (!finished1) {
            // all confirmation logic
            // we should add a cute checkbox are you sure etc.
            changeFormState(false, jLabel1, hiddenTextField1, lockBtn1, redXBtn1, confirmBtn1);
            finished1 = true;

        }
    }//GEN-LAST:event_confirmBtn1MouseReleased

    private void lockBtn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lockBtn2MouseReleased
        if (!finished2) {

            try {
                new MPlayer().clickSound();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            lockUnlock2(lockBtn2, hiddenTextField2);
        }
    }//GEN-LAST:event_lockBtn2MouseReleased

    private void lockBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lockBtn2ActionPerformed

    private void redXBtn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redXBtn2MouseReleased
        if (!finished2) {
            // all confirmation logic
            // we should add a cute checkbox are you sure etc.

            changeFormState(true, jLabel2, hiddenTextField2, lockBtn2, redXBtn2, confirmBtn2);
            finished2 = true;
        }
    }//GEN-LAST:event_redXBtn2MouseReleased
    private void StopWatch() {

    }
    private void confirmBtn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtn2MouseReleased
        if (!finished2) {
            // all confirmation logic
            // we should add a cute checkbox are you sure etc.

            changeFormState(false, jLabel2, hiddenTextField2, lockBtn2, redXBtn2, confirmBtn2);
            finished2 = true;
        }
    }//GEN-LAST:event_confirmBtn2MouseReleased

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        if (addButton.getY() == 170) {

            hiddenTextField1.setEditable(true);
            hiddenTextField1.setFont(font);
            hiddenTextField1.setEnabled(true);
            hiddenTextField1.setOpaque(false);
            hiddenTextField1.setFocusable(true);
           
            jLabel1.setLocation(80, jLabel1.getY());

            confirmBtn1.setLocation(200, confirmBtn1.getY());
            redXBtn1.setLocation(240, redXBtn1.getY());
            lockBtn1.setLocation(220, lockBtn1.getY());

            addButton.setLocation(addButton.getX(), addButton.getY() + 80);

            task2 = true;
        } else if (addButton.getY() == 250) {

            hiddenTextField2.setEditable(true);
            hiddenTextField2.setFont(font);
          
            hiddenTextField2.setEnabled(true);
            hiddenTextField2.setOpaque(false);
            hiddenTextField2.setFocusable(true);

            jLabel2.setLocation(80, jLabel2.getY());

            confirmBtn2.setLocation(200, confirmBtn2.getY());
            redXBtn2.setLocation(240, redXBtn2.getY());
            lockBtn2.setLocation(220, lockBtn2.getY());

            addButton.setLocation(addButton.getX(), -500);

            task3 = true;
        }
    }//GEN-LAST:event_addButtonMouseReleased

    private void hiddenTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hiddenTextField1KeyPressed
        if (evt.getKeyCode() == 10) {
            try {

                lockUnlock1(lockBtn1, hiddenTextField1);

                locked1 = 1;

                new MPlayer().typing2Sound();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyChar() > 32 && evt.getKeyChar() < 126) {
            try {
                new MPlayer().typing4Sound();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_hiddenTextField1KeyPressed

    private void hiddenTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hiddenTextField2KeyPressed
        if (evt.getKeyCode() == 10) {
            try {

                lockUnlock2(lockBtn2, hiddenTextField2);

                locked2 = 1;

                new MPlayer().typing2Sound();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyChar() > 32 && evt.getKeyChar() < 126) {
            try {
                new MPlayer().typing4Sound();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_hiddenTextField2KeyPressed

    private void expandBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expandBtnMouseReleased
        if (expandBtn.isSelected()) {

            expansionLabel.setLocation(23, expansionLabel.getY());
            jToggleButton1.setLocation(30, jToggleButton1.getY());
            jToggleButton1.setEnabled(true);
            expandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/arrowSmallerCLS32.pdf.png")));
            expandBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/arrowbigger32.pdf.png")));
        } else {
            expansionLabel.setLocation(76, expansionLabel.getY());
            jToggleButton1.setLocation(73, jToggleButton1.getY());
            jToggleButton1.setEnabled(false);
            expandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/arrowsmaller32.pdf.png")));
            expandBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/util/arrowbigger32.pdf.png")));
        }

    }//GEN-LAST:event_expandBtnMouseReleased

    private void firstTaskFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstTaskFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstTaskFieldActionPerformed

    private void firstTaskFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstTaskFieldKeyReleased


    }//GEN-LAST:event_firstTaskFieldKeyReleased

    private void expandBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expandBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expandBtnActionPerformed

    private void jToggleButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseReleased
        if (jToggleButton1.isSelected()) {
            ps.setLocation((int) (expansionLabel.getLocationOnScreen().getX()) - 400, (int) (expansionLabel.getLocationOnScreen().getY()) - 200);
            ps.setVisible(true);

        } else {
            ps.setVisible(false);

        }
    }//GEN-LAST:event_jToggleButton1MouseReleased

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
       if (task2 && task3){
           
            // first task repaint
            hiddenTextField1.setEditable(true);
            hiddenTextField1.setFont(font);
            hiddenTextField1.setEnabled(true);
            hiddenTextField1.setOpaque(false);
            hiddenTextField1.setFocusable(true);
           
            jLabel1.setLocation(80, jLabel1.getY());

            confirmBtn1.setLocation(200, confirmBtn1.getY());
            redXBtn1.setLocation(240, redXBtn1.getY());
            lockBtn1.setLocation(220, lockBtn1.getY());
            
            // 2nd task repaint due minimising bug
            hiddenTextField2.setEditable(true);
            hiddenTextField2.setFont(font);
          
            hiddenTextField2.setEnabled(true);
            hiddenTextField2.setOpaque(false);
            hiddenTextField2.setFocusable(true);

            jLabel2.setLocation(80, jLabel2.getY());

            confirmBtn2.setLocation(200, confirmBtn2.getY());
            redXBtn2.setLocation(240, redXBtn2.getY());
            lockBtn2.setLocation(220, lockBtn2.getY());

            addButton.setLocation(addButton.getX(), -500);
          

            

       }else if(task2){
           
       }else if (task3){
       }
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
         if (task2 && task3){
           
            // first task repaint
            hiddenTextField1.setEditable(true);
            hiddenTextField1.setFont(font);
            hiddenTextField1.setEnabled(true);
            hiddenTextField1.setOpaque(false);
            hiddenTextField1.setFocusable(true);
           
            jLabel1.setLocation(80, jLabel1.getY());

            confirmBtn1.setLocation(200, confirmBtn1.getY());
            redXBtn1.setLocation(240, redXBtn1.getY());
            lockBtn1.setLocation(220, lockBtn1.getY());
            
            // 2nd task repaint due minimising bug
            hiddenTextField2.setEditable(true);
            hiddenTextField2.setFont(font);
          
            hiddenTextField2.setEnabled(true);
            hiddenTextField2.setOpaque(false);
            hiddenTextField2.setFocusable(true);

            jLabel2.setLocation(80, jLabel2.getY());

            confirmBtn2.setLocation(200, confirmBtn2.getY());
            redXBtn2.setLocation(240, redXBtn2.getY());
            lockBtn2.setLocation(220, lockBtn2.getY());

            addButton.setLocation(addButton.getX(), -500);
          

            

       }else if(task2){
            hiddenTextField1.setEditable(true);
            hiddenTextField1.setFont(font);
            hiddenTextField1.setEnabled(true);
            hiddenTextField1.setOpaque(false);
            hiddenTextField1.setFocusable(true);
           
            jLabel1.setLocation(80, jLabel1.getY());

            confirmBtn1.setLocation(200, confirmBtn1.getY());
            redXBtn1.setLocation(240, redXBtn1.getY());
            lockBtn1.setLocation(220, lockBtn1.getY());
            
            addButton.setLocation(addButton.getX(), addButton.getY() + 80);
       }else if (task3){
            hiddenTextField2.setEditable(true);
            hiddenTextField2.setFont(font);
          
            hiddenTextField2.setEnabled(true);
            hiddenTextField2.setOpaque(false);
            hiddenTextField2.setFocusable(true);

            jLabel2.setLocation(80, jLabel2.getY());

            confirmBtn2.setLocation(200, confirmBtn2.getY());
            redXBtn2.setLocation(240, redXBtn2.getY());
            lockBtn2.setLocation(220, lockBtn2.getY());

            addButton.setLocation(addButton.getX(), -500);
       }
    }//GEN-LAST:event_formWindowGainedFocus

    private void saveInputs() {
        
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(firstTaskField.getText() + "\n" + hiddenTextField1.getText() + "\n" + hiddenTextField2.getText() + "\n #######|     Task details    |####### \n" + ps.postItTextArea.getText());

        } catch (IOException e) {
        } finally {
            try {

                writer.close();
            } catch (IOException e) {
            }

        }

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel backGround;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton confirmBtn1;
    private javax.swing.JButton confirmBtn2;
    private javax.swing.JLabel dragLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JToggleButton expandBtn;
    private javax.swing.JLabel expansionLabel;
    private javax.swing.JLabel firstLabel;
    private javax.swing.JTextField firstTaskField;
    private javax.swing.JTextField hiddenTextField1;
    private javax.swing.JTextField hiddenTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton lockBtn;
    private javax.swing.JButton lockBtn1;
    private javax.swing.JButton lockBtn2;
    private javax.swing.JButton redXBtn;
    private javax.swing.JButton redXBtn1;
    private javax.swing.JButton redXBtn2;
    // End of variables declaration//GEN-END:variables

}
