
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public final class Pinakas_grammaton extends JPanel {

    int metrhths_anakatema_ola, metrhths_anakatema_seires, metrhths_anakatema_steiles, metrhths_diagrafon, metrhths_enalagon;
    int telikh_seira_allaghs, telikh_sthlh_allaghs, arxikh_grammh_allaghs, arxikh_sthlh_allaghs;
    int lekseis_pou_brethikan, vathmologia_lekshs, sko_paixth, size=8, lekseis;
    int kokkino=0, mple=0, mpalader=0;
    String trexon_str;

    ArrayList <Koumpi> trexon_epilegmena=new ArrayList<>();
    ArrayList <String> lekseis_na_brethoun=new ArrayList<>();
    
    Grafiko g;
    JButton elehxos;
    JFrame frame;
    JPanel panel, pinakas_panel;
    JPanel[][] panel_grammaton;
    Koumpi[][] pinakas;
    ArrayList <String> list=new ArrayList<>();
    
    public Pinakas_grammaton( ArrayList list, Grafiko g){
        
        pinakas_panel = new JPanel();
        this.g=g;
        this.list=list;
        metrhths_anakatema_ola=0;
        metrhths_anakatema_seires=0;
        metrhths_anakatema_steiles=0;
        metrhths_diagrafon=0;
        metrhths_enalagon=0;
        lekseis_pou_brethikan=0;
        vathmologia_lekshs=0;
        sko_paixth=0;
        pinakas = new Koumpi[size][size];
        
        panel = new JPanel();
        pinakas_panel.setLayout(new BorderLayout());
        pinakas_panel.add(panel,BorderLayout.CENTER);
        JPanel buttonpanel = new JPanel();
        elehxos = new JButton("Έλεγχος Λέξης!");
        elehxos.addActionListener((ActionEvent e) -> {
            elegxos_lekshs();
        });
        buttonpanel.add(elehxos);
        pinakas_panel.add(buttonpanel,BorderLayout.PAGE_END);
        frame=g.Grafiko(pinakas_panel);
        dummy_panel();
    }
    
    public void setframe(JFrame frame){
        this.frame=frame;
    };
    
    public void setsize(int size){
        this.size = size;
    }

    void enallagh(int grammh1,int sthlh1,int grammh2,int sthlh2){
        Koumpi temp = pinakas[grammh1][sthlh1];
        pinakas[grammh1][sthlh1] = pinakas[grammh2][sthlh2];
        pinakas[grammh2][sthlh2] = temp;
    }

    void diagrafh_grammhs(int grammh){
        if (metrhths_diagrafon<Metavlites.deletes){
            Random r = new Random();
            for (int i=0;i<size;i++){
                pinakas[grammh][i]=koumpi_gramma((char)' ');
            }
            for (int i=0;i<size;i++){
                pinakas[grammh][i]=koumpi_gramma((char)('Α'+r.nextInt(24)));
            }
            enhmerosh_oloklhrou_panel(size);
            metrhths_diagrafon++;
        }
        if (metrhths_diagrafon==Metavlites.deletes){
            g.button_diagrafh();
        }
        g.enhmerosh_pedion(g.label_diagrafh_grammhs, metrhths_diagrafon, Metavlites.deletes);
    
    }
    void anakatema_grammhs(int grammh){
        if (metrhths_anakatema_seires<Metavlites.anakatema_grammhs){
            ArrayList<Koumpi> letterlist = new ArrayList();
            for (int i=0;i<size;i++){
                letterlist.add(pinakas[grammh][i]);
            }
            Collections.shuffle(letterlist, new Random());
            for (int i=0;i<size;i++){
                pinakas[grammh][i] = letterlist.get(i);
            }
            enhmerosh_oloklhrou_panel(size);
            metrhths_anakatema_seires++;
        }
        if(metrhths_anakatema_seires==Metavlites.anakatema_grammhs){
            g.button_anadiataksh_grammhs();
        }
        g.enhmerosh_pedion(g.label_anakatema_grammhs, metrhths_anakatema_seires, Metavlites.anakatema_grammhs);
    }

    void anakatema_sthlhs(int sthlh){
         if (metrhths_anakatema_steiles<Metavlites.anakatema_sthlhs){
            ArrayList<Koumpi> letterlist = new ArrayList();
            for (int i=0;i<size;i++)
                letterlist.add(pinakas[i][sthlh]);
            Collections.shuffle(letterlist, new Random());
            for (int i=0;i<size;i++){
                pinakas[i][sthlh] = letterlist.get(i);
            }
            enhmerosh_oloklhrou_panel(size);
            metrhths_anakatema_steiles++;
        }
        if (metrhths_anakatema_steiles==Metavlites.anakatema_sthlhs){
            g.button_anadiataksh_sthlhs();
        }
        g.enhmerosh_pedion(g.label_anakatema_sthlhs, metrhths_anakatema_steiles, Metavlites.anakatema_sthlhs);
    }

    Koumpi koumpi_gramma(char c){
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0:
                if (Kokkino_koumpi.getMegisto()>=kokkino){
                    kokkino++;
                    return new Kokkino_koumpi(c);
                }
            case 1:
                if (Mple_koumpi.getMegisto()>=mple){
                    mple++;
                    return new Mple_koumpi(c);
                }
            case 2:
                if (Mpalader.getMegisto()>=mpalader){
                    mpalader++;
                    return new Mpalader();
                }
            default:
              return new Aspro_koumpi(c);  
        }
    }

    void dummy_panel(){
        mple=0;
        kokkino=0;
        mpalader=0;
        panel.removeAll();
        panel_grammaton = new JPanel[size][size];
        GridLayout gridlayout = new GridLayout(size,size);
        gridlayout.setHgap(10);
        gridlayout.setVgap(10);
        panel.setLayout(gridlayout);

        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                panel_grammaton[i][j] = new JPanel();
                panel_grammaton[i][j].setLayout(new GridBagLayout());
                panel_grammaton[i][j].setBackground(Color.WHITE); 
                panel_grammaton[i][j].add(new JLabel(" "+" (???)"));
                panel.add(panel_grammaton[i][j]);
            }
        }
        frame.revalidate();
        frame.repaint();
    }
	
    void dhmiourgia_panel(){
        mple=0;
        kokkino=0;
        mpalader=0;
        
        Random random = new Random();
        ArrayList<Character> charlist= new ArrayList(); 
        int xarakthres_sunolo=0, xarakthres_diorthosh_sunolo=0;
        lekseis=0;
        String dictionaryword;
        do{
            dictionaryword = list.get(lekseis);
            for (int i=0;i<dictionaryword.length();i++){
                charlist.add(dictionaryword.charAt(i));
                xarakthres_sunolo++;
            }
            lekseis++;
            if(xarakthres_sunolo>(size*size)){
                xarakthres_diorthosh_sunolo=xarakthres_sunolo;
                for (int i=xarakthres_sunolo-1;i>=xarakthres_sunolo-dictionaryword.length();i--){
                    charlist.remove(i);
                    xarakthres_diorthosh_sunolo--;
                }
                lekseis--;
            }else{
                lekseis_na_brethoun.add(dictionaryword);
            }
        }while (xarakthres_sunolo<(size*size));
        xarakthres_sunolo=xarakthres_diorthosh_sunolo;
        for (int i=xarakthres_sunolo;i<size*size;i++){
            charlist.add((char)('Α'+random.nextInt(24)));
            
        }
        Collections.shuffle(charlist, new Random());
        for (int i=0;i<size;i++)
            for (int j=0;j<size;j++)
                pinakas[i][j] = koumpi_gramma(charlist.get(i*size+j));
        
        panel.removeAll();
        panel_grammaton = new JPanel[size][size];
        GridLayout gridlayout = new GridLayout(size,size);
        gridlayout.setHgap(10);
        gridlayout.setVgap(10);
        panel.setLayout(gridlayout);
        
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                panel_grammaton[i][j] = new JPanel();
                panel_grammaton[i][j].setLayout(new GridBagLayout());
                enhmerohsh_grammatos(i,j,1,0);
                panel_grammaton[i][j].addMouseListener(new mouselistener(i,j));
                panel.add(panel_grammaton[i][j]);
            }
        }
        g.Grafiko(pinakas_panel);
        g.enhmerosh_pedion(g.label_lekseis_brethikan, lekseis_pou_brethikan, lekseis);
        revalidate();
    }
    void enhmerosh_oloklhrou_panel(int size){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                enhmerohsh_grammatos(i,j,1,0);
            }
        }
        revalidate();
    }

    void enhmerohsh_grammatos(int grammh,int sthlh, int save, int save2){
        if (pinakas[grammh][sthlh].epilegmeno()==1)
            panel_grammaton[grammh][sthlh].setBackground(Color.YELLOW);
        else 
            panel_grammaton[grammh][sthlh].setBackground(Color.WHITE); 
        
        if (pinakas[grammh][sthlh] instanceof Mple_koumpi){
            if (pinakas[grammh][sthlh].epilegmeno()==1)
                panel_grammaton[grammh][sthlh].setBackground(Color.CYAN);
            else
                panel_grammaton[grammh][sthlh].setBackground(Color.BLUE);
        }
        else if (pinakas[grammh][sthlh] instanceof Kokkino_koumpi){
            if (pinakas[grammh][sthlh].epilegmeno()==1)
                panel_grammaton[grammh][sthlh].setBackground(Color.PINK);
            else
                panel_grammaton[grammh][sthlh].setBackground(Color.RED);
        }
        if(save==1)
            panel_grammaton[grammh][sthlh].removeAll();
        if (pinakas[grammh][sthlh] instanceof Mpalader){
            panel_grammaton[grammh][sthlh].removeAll();
            panel_grammaton[grammh][sthlh].add(new JLabel());
        }
        if(save2==0)
            panel_grammaton[grammh][sthlh].add(new JLabel(pinakas[grammh][sthlh].toString()+" ("+String.valueOf(pinakas[grammh][sthlh].getBathmologia()+")")));
    }

    void allShuffle(){
        if (metrhths_anakatema_ola<Metavlites.anakatema_ola){
            metrhths_anakatema_ola++;
            ArrayList<Koumpi> letterlist = new ArrayList();
            for (int i=0;i<size;i++)
                for (int j=0;j<size;j++)
                    letterlist.add(pinakas[i][j]);
            Collections.shuffle(letterlist, new Random());
            for (int i=0;i<size;i++)
                for (int j=0;j<size;j++){
                    pinakas[i][j] = letterlist.get(i*size+j);
                }
            enhmerosh_oloklhrou_panel(size);
            g.enhmerosh_pedion(g.label_anakatema_ola, metrhths_anakatema_ola, Metavlites.anakatema_ola);
            if (metrhths_anakatema_ola==Metavlites.anakatema_ola){
                g.button_anadiataksh_ola();
            }
                
        }
    }

    public void elegxos_lekshs(){
        for(String i: lekseis_na_brethoun){
            if(i.equals(trexon_str)){
                lekseis_pou_brethikan++;
                g.enhmerosh_pedion(g.label_lekseis_brethikan, lekseis_pou_brethikan, lekseis);
                revalidate();
            }
        }
    }

    class mouselistener implements MouseListener{
        int grammh;
        int sthlh;
        
        mouselistener(int grammh, int sthlh){
            this.grammh = grammh;
            this.sthlh = sthlh;
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {

            if (pinakas[grammh][sthlh] instanceof Mpalader){
                    JPopupMenu epiloges_mpalader = new JPopupMenu();
                    epiloges_mpalader.add("Επέλεξε πιο γράμμα θες:");
                    for (char c='Α';c<='Ω';c++){
                        JMenuItem charitem = new JMenuItem(String.valueOf(c));
                        charitem.addActionListener(new SetWildCard(c));
                        epiloges_mpalader.add(charitem);
                    }
                    epiloges_mpalader.show(me.getComponent(),me.getX(), me.getY());
                }
            else{
                if (pinakas[grammh][sthlh].epilegmeno()==1){
                    pinakas[grammh][sthlh].epelekse(0);
                    enhmerohsh_grammatos(grammh,sthlh,0,1);
                    trexon_epilegmena.remove(pinakas[grammh][sthlh]);
                    trexon_str="";
                    for(Koumpi i: trexon_epilegmena){
                        trexon_str+=i;
                    }
                    g.enhmerosh_pedion(g.label_uparxon_leksh, trexon_str);
                    revalidate();
                }
                else if (pinakas[grammh][sthlh].epilegmeno()==0){
                    pinakas[grammh][sthlh].epelekse(1);
                    enhmerohsh_grammatos(grammh,sthlh,0,1);
                    trexon_epilegmena.add(pinakas[grammh][sthlh]);
                    trexon_str="";
                    for(Koumpi i: trexon_epilegmena){
                        trexon_str+=i;
                    }
                    g.enhmerosh_pedion(g.label_uparxon_leksh, trexon_str);
                    revalidate();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {
            if (metrhths_enalagon<Metavlites.letter_swap)
                if (!((telikh_seira_allaghs==arxikh_grammh_allaghs) && (telikh_sthlh_allaghs==arxikh_sthlh_allaghs)) &&
                       !((telikh_seira_allaghs==this.grammh) && (telikh_sthlh_allaghs==this.sthlh)) ){
                        enallagh(this.grammh, this.sthlh, telikh_seira_allaghs, telikh_sthlh_allaghs);
                        enhmerohsh_grammatos(this.grammh,this.sthlh,1,0);
                        enhmerohsh_grammatos(telikh_seira_allaghs,telikh_sthlh_allaghs,1,0);
                        metrhths_enalagon++;
                        g.enhmerosh_pedion(g.label_anakatema_grammaton, metrhths_enalagon, Metavlites.letter_swap);
                }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            telikh_seira_allaghs=this.grammh;
            telikh_sthlh_allaghs=this.sthlh;
        }
        
        @Override
        public void mouseExited(MouseEvent me) {
            arxikh_grammh_allaghs=this.grammh;
            arxikh_sthlh_allaghs=this.sthlh;
        }
        
        class SetWildCard implements ActionListener{
            char c;
            SetWildCard(char c){
                this.c = c;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                pinakas[grammh][sthlh] = new Aspro_koumpi(c); 
                enhmerohsh_grammatos(grammh,sthlh,0,0);
                revalidate();
            }
        }
    }
}
