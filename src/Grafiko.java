import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Grafiko implements ActionListener {
    JLabel label_diagrafh_grammhs, label_anakatema_grammhs, label_anakatema_sthlhs, label_anakatema_ola, label_anakatema_grammaton;
    JLabel label_stoxos_skor, label_skore, label_onoma_paixth;
    JLabel label_lekseis_brethikan, label_leksh_brethike, label_skore_lekshs, label_uparxon_leksh;
    JTextField t1,t2,t3,t4;
    JButton button_anadiataksh_ola, button_diagrafh, button_anadiataksh_grammhs, button_anadiataksh_sthlhs;
    int size;
    JFrame frame;
    JMenuItem manou_paixnidiou;
    Pinakas_grammaton pinakas_grammaton;
    ArrayList list;
    Grafiko g;
    
    public JButton getbutton_diagrafh(){
        return button_diagrafh;
    }
    
    Grafiko(){}
    
    public void setgrafiko(ArrayList list, Grafiko g){
        this.g=g;
        this.list=list;
        pinakas_grammaton = new Pinakas_grammaton(list,g);
    }
    private JMenuBar Menu() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Μενού");
        bar.add(menu);
        manou_paixnidiou = new JMenuItem("Νέο παιχνίδι");
        manou_paixnidiou.addActionListener(this);
        menu.add(manou_paixnidiou);
        JMenuItem endmenu = new JMenuItem("Ακύρωση/Τερματισμός παιχνιδιού");
        endmenu.addActionListener(this);
        menu.add(endmenu);
        JMenuItem insertdatamenu = new JMenuItem("Εισαγωγή στοιχείων παίκτη");
        insertdatamenu.addActionListener(this);
        menu.add(insertdatamenu);
        JMenuItem helpsettingsmenu = new JMenuItem("Ρυθμίσεις βοηθειών");
        helpsettingsmenu.addActionListener(this);
        menu.add(helpsettingsmenu);
        
        JMenuItem searchwordsmenu = new JMenuItem("Αναζήτηση αρχείου λέξεων");
        searchwordsmenu.addActionListener(this);
        menu.add(searchwordsmenu);
        
        JMenuItem exitmenu = new JMenuItem("Έξοδος");
        exitmenu.addActionListener(this);
        menu.add(exitmenu);
        
        JMenu toolsmenu = new JMenu("Εργαλεία");
        bar.add(toolsmenu);
        JMenuItem helpmenu = new JMenuItem("Βοήθεια");
        helpmenu.addActionListener(this);
        toolsmenu.add(helpmenu);
        JMenuItem aboutmenu = new JMenuItem("About...");
        aboutmenu.addActionListener(this);
        toolsmenu.add(aboutmenu);
        
        return bar;
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Νέο παιχνίδι":
                String [] choice={"5x5","8x8","10x10"};
                String display=(String)JOptionPane.showInputDialog(null,"Epilekse eidos paixnidiou: ","Diastash",JOptionPane.PLAIN_MESSAGE,null,choice,choice[1]);
                switch (display) {
                    case "5x5":
                        pinakas_grammaton=null;
                        pinakas_grammaton = new Pinakas_grammaton(list,g);
                        pinakas_grammaton.setsize(5);
                        pinakas_grammaton.dhmiourgia_panel();
                        break;
                    case "8x8":
                        pinakas_grammaton=null;
                        pinakas_grammaton = new Pinakas_grammaton(list,g);
                        pinakas_grammaton.setsize(8);
                        pinakas_grammaton.dhmiourgia_panel();
                        break;
                    default:
                        pinakas_grammaton=null;
                        pinakas_grammaton = new Pinakas_grammaton(list,g);
                        pinakas_grammaton.setsize(10);
                        pinakas_grammaton.dhmiourgia_panel();
                        break;
                }
                break;
            case "Ακύρωση/Τερματισμός παιχνιδιού":
                pinakas_grammaton.setframe(frame);
                pinakas_grammaton.dummy_panel();
                break;
            case "Εισαγωγή στοιχείων παίκτη":
                String name = JOptionPane.showInputDialog(null, "Dose onoma:");
                Paikths p = new Paikths(name);
                label_onoma_paixth.setText(name);
                break;
            case "Ρυθμίσεις βοηθειών":
                String metablhth_diagrafh = JOptionPane.showInputDialog(null, "Dose oria diagrafon grammon(Trexon orio:"+Metavlites.deletes+"):");
                if(Integer.parseInt(metablhth_diagrafh)>1){
                    Metavlites.deletes=Integer.parseInt(metablhth_diagrafh);
                    enhmerosh_pedion(label_diagrafh_grammhs,0,Metavlites.deletes);
                    pinakas_grammaton.dummy_panel();
                }
                String metablhth_anadiataksh_sthlhs = JOptionPane.showInputDialog(null, "Dose oria anadiataksh sthlhs(Trexon orio:"+Metavlites.anakatema_sthlhs+"):");
                if(Integer.parseInt(metablhth_anadiataksh_sthlhs)>1){
                    Metavlites.deletes=Integer.parseInt(metablhth_anadiataksh_sthlhs);
                    enhmerosh_pedion(label_anakatema_sthlhs,0,Metavlites.deletes);
                    pinakas_grammaton.dummy_panel();
                }
                break;
            case "Αναζήτηση αρχείου λέξεων":
                JFileChooser filchooser = new JFileChooser();
                if (filchooser.showOpenDialog(filchooser) == JFileChooser.APPROVE_OPTION) {
                    BufferedReader br = null;
                    try {
                        File file = filchooser.getSelectedFile();
                        br = new BufferedReader( new InputStreamReader(new FileInputStream(file), "ISO-8859-7"));
                        String line;
                        while((line = br.readLine())!= null){
                            list.add(line);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Grafiko.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Grafiko.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Grafiko.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            br.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Grafiko.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }   break;
            case "Έξοδος":
                System.exit(0);
            case "Βοήθεια":
                JOptionPane.showMessageDialog (frame, "To παιχνίδι σου παρέχει 5 βοήθειες:\n1)Διαγραφή γραμμής\n2)Αναδιάταξη στήλης\n3)Αναδιάταξη γραμμής\n4)Αναδιάταξη ολόκληρου του πίνακα\n5)Εναλλαγή δύο γραμμάτων", "Βοήθεια", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "About...":
                JOptionPane.showMessageDialog (frame, "Rusnac Cristina - 321/2012161 ", "About...", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
    }
    public JFrame Grafiko(JPanel pinakas){
        try{
            frame.dispose();
        }catch(Exception e){
            
        }
        frame = new JFrame("Kryptolekso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setJMenuBar(Menu());
        
        frame.add(pinakas,BorderLayout.LINE_START);
        
        JPanel label_statistikon = new JPanel();
        GridLayout gridlayout = new GridLayout(15,3);
        gridlayout.setVgap(5);
        label_statistikon.setLayout(gridlayout);
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Χαρακτηριστικά παίχτη:"));
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Όνομα παίχτη:"));
        label_onoma_paixth = new JLabel("");
        label_statistikon.add(label_onoma_paixth);
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Βοήθειες"));
        label_statistikon.add(new JLabel());
        button_diagrafh =new JButton("Διαγραφές γραμμής");
        button_diagrafh.addActionListener((ActionEvent e) -> {
            int grammh_pinaka = Integer.parseInt(t1.getText());
            pinakas_grammaton.diagrafh_grammhs(grammh_pinaka);
        });
        label_statistikon.add(button_diagrafh);
        t1 = new JTextField();
        t1.setText("0");
        label_statistikon.add(t1);
        label_diagrafh_grammhs = new JLabel("0/"+String.valueOf(Metavlites.deletes));
        label_statistikon.add(label_diagrafh_grammhs);
        button_anadiataksh_grammhs =new JButton("Αναδιατάξεις γραμής");
        button_anadiataksh_grammhs.addActionListener((ActionEvent e) -> {
            int grammh = Integer.parseInt(t2.getText());
            pinakas_grammaton.anakatema_grammhs(grammh);
        });
        label_statistikon.add(button_anadiataksh_grammhs);
        t2 = new JTextField();
        t2.setText("0");
        label_statistikon.add(t2);
        label_anakatema_grammhs = new JLabel("0/"+String.valueOf(Metavlites.anakatema_grammhs));
        label_statistikon.add(label_anakatema_grammhs);
        button_anadiataksh_sthlhs =new JButton("Αναδιατάξεις στήλης");
        button_anadiataksh_sthlhs.addActionListener((ActionEvent e) -> {
            int grammh = Integer.parseInt(t3.getText());
            pinakas_grammaton.anakatema_sthlhs(grammh);
        });
        label_statistikon.add(button_anadiataksh_sthlhs);
        t3 = new JTextField();
        t3.setText("0");
        label_statistikon.add(t3);
        label_anakatema_sthlhs  = new JLabel("0/"+String.valueOf(Metavlites.anakatema_sthlhs));
        label_statistikon.add(label_anakatema_sthlhs);
        button_anadiataksh_ola =new JButton("Αναδιατάξεις ταμπλό");
        button_anadiataksh_ola.addActionListener((ActionEvent e) -> {
            pinakas_grammaton.allShuffle();
        });
        label_statistikon.add(button_anadiataksh_ola);
        t4 = new JTextField(1);
        t4.setText("0");
        label_statistikon.add(t4);
        label_anakatema_ola  = new JLabel("0/"+String.valueOf(Metavlites.anakatema_ola));
        label_statistikon.add(label_anakatema_ola);
        label_statistikon.add(new JLabel("Εναλλαγές γραμμάτων"));
        label_anakatema_grammaton = new JLabel("0/"+String.valueOf(Metavlites.letter_swap));
        label_statistikon.add(label_anakatema_grammaton);
        label_statistikon.add(new JLabel(""));
        
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Σκορ:"));
        label_statistikon.add(new JLabel());
        label_stoxos_skor = new JLabel(String.valueOf(Metavlites.skor));
        label_statistikon.add(new JLabel("Στόχος:"));
        label_statistikon.add(label_stoxos_skor);
        label_skore = new JLabel("0");
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Συνολική Βαθμολογία:"));
        label_statistikon.add(label_skore);
        label_skore_lekshs = new JLabel("0");
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Βαθμολογία Λέξης:"));
        label_statistikon.add(label_skore_lekshs);
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Λέξεις που βρέθηκαν:"));
        label_lekseis_brethikan = new JLabel("0/"+String.valueOf(Metavlites.lekseis));
        label_statistikon.add(label_lekseis_brethikan);
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Σχηματισμένη λέξη:"));
        label_uparxon_leksh = new JLabel("");
        label_statistikon.add(label_uparxon_leksh);
        label_statistikon.add(new JLabel());
        label_statistikon.add(new JLabel("Βρέθηκε λέξη:"));
        label_leksh_brethike = new JLabel("");
        label_statistikon.add(label_leksh_brethike);
        frame.add(label_statistikon,BorderLayout.AFTER_LINE_ENDS);
        frame.setSize(1000, 500);
        frame.setVisible(true);
        
        return frame;
    }
    public void button_diagrafh(){
        button_diagrafh.setEnabled(false);
    }
    
    public void button_anadiataksh_grammhs(){
        button_anadiataksh_grammhs.setEnabled(false);
    }
    
    public void button_anadiataksh_sthlhs(){
        button_anadiataksh_sthlhs.setEnabled(false);
    }
    
    public void button_anadiataksh_ola(){
        button_anadiataksh_ola.setEnabled(false);
    }

    void enhmerosh_pedion(JLabel label,int trexon,int maxmetavl){
        label.setText(String.valueOf(trexon)+"/"+String.valueOf(maxmetavl));
    }
    

    void enhmerosh_pedion(JLabel label,String str){
        label.setText(str);
    }
    
}
