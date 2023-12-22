import javax.imageio.ImageIO;
import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReproductorFrame extends JFrame {
    private JPanel p_Actual;
    private JPanel nuevoPanelEx;
    public String tx="";
    public String dis_controles, dis_panelcambio, dis_menu, dis_botones, dis_LetraBoton/*letras de botones*/, dis_LetraPanel/*letras de panel*/, dis_BarraC1/*barra de cancion 1*/, ImagenBarra, 
        dis_BarraC2/*barra de cancion1*/, dis_CId/*campo ID*/, dis_CArtista/*campo artista*/, dis_CCancion/*campo cancion*/, dis_CPeso/*campo peso*/, dis_CTiempo/*campo tiempo*/, dis_CAlbun/*campo albun*/,dis_LetraRec;
    public String direccion1, direccion2, direccion3, direccion4, direccion5, 
        direccion6, direccion7,direccion8, direccion9, direccion10;
    public String refernsiaAr="", refernsiaAl="",t_album1="",t_album2="",t_album3="",t_album4="";int minimo=0, minimoAl=0;
    public ReproductorFrame(int modelo, String Correo) {
        //Variables base------
        if(modelo==1){
            dis_menu="#A0B1D8";             dis_botones="#395FB8";      dis_BarraC1="#A7A7A7";  dis_CArtista="#787878"; dis_CTiempo="#666666";  ImagenBarra="Imagenes/Barra.jpg";
            dis_panelcambio="#E3E3E3";      dis_LetraBoton="#FFFFFF";   dis_BarraC2="#4B75C8";  dis_CCancion="#666666"; dis_CAlbun="#787878";
            dis_controles="#5F5F5F";        dis_LetraPanel="#000000";   dis_CId="#666666";      dis_CPeso="#787878";    dis_LetraRec="#FFFFFF";   
        } else if(modelo==2){
            dis_menu="#D62E21";             dis_botones="#FFF95F";      dis_BarraC1="#FF3727";  dis_CArtista="#F58D07"; dis_CTiempo="#FFF95F";  ImagenBarra="Imagenes/BarraNav.png";
            dis_panelcambio="#EDECEC";      dis_LetraBoton="#000000";   dis_BarraC2="#70F05D";  dis_CCancion="#75F94D"; dis_CAlbun="#E100FF";
            dis_controles="#75F94D";        dis_LetraPanel="#000000";   dis_CId="#0023F5";      dis_CPeso="#F91706";    dis_LetraRec="#000000";
        } else if(modelo==3){
            dis_menu="#008DC9";             dis_botones="#CDFFF3";      dis_BarraC1="#8DDEB1";  dis_CArtista="#FF7C2E"; dis_CTiempo="#FFF95F";  ImagenBarra="Imagenes/BarraMad.png";
            dis_panelcambio="#FFBCE9";      dis_LetraBoton="#000000";   dis_BarraC2="#2CC728";  dis_CCancion="#75F94D"; dis_CAlbun="#8C8C8C";
            dis_controles="#B327FF";        dis_LetraPanel="#000000";   dis_CId="#BE52FF";      dis_CPeso="#FF1806";    dis_LetraRec="#000000";
        }else if(modelo==4){
            dis_menu="#F2731E";             dis_botones="#FFF95F";      dis_BarraC1="#A7A7A7";  dis_CArtista="#9000BD"; dis_CTiempo="#F2731E";  ImagenBarra="Imagenes/BarraHaw.png";
            dis_panelcambio="#888A85";      dis_LetraBoton="#000000";   dis_BarraC2="#F2731E";  dis_CCancion="#F2731E"; dis_CAlbun="#9000BD";
            dis_controles="#5B5C59";        dis_LetraPanel="#000000";   dis_CId="#F2731E";      dis_CPeso="#9000BD";    dis_LetraRec="#000000";
        }else if(modelo==5){
            dis_menu="#000000";             dis_botones="#6B6B6B";      dis_BarraC1="#C3C3C3";  dis_CArtista="#656565"; dis_CTiempo="#949494";  ImagenBarra="Imagenes/BarraOCU.png";
            dis_panelcambio="#403F3F";      dis_LetraBoton="#FFFFFF";   dis_BarraC2="#7F7F7F";  dis_CCancion="#949494"; dis_CAlbun="#656565";
            dis_controles="#080808";        dis_LetraPanel="#FFFFFF";   dis_CId="#949494";      dis_CPeso="#656565";    dis_LetraRec="#FFFFFF";
        }else if(modelo==6){
            dis_menu="#CF0000";             dis_botones="#0E8202";      dis_BarraC1="#FF7C7E";  dis_CArtista="#CF0000"; dis_CTiempo="#0E8202";  ImagenBarra="Imagenes/BarraInde.png";
            dis_panelcambio="#72CF6A";      dis_LetraBoton="#FFFFFF";   dis_BarraC2="#9AFF8F";  dis_CCancion="#FFFFFF"; dis_CAlbun="#0E8202";
            dis_controles="#5F5F5F";        dis_LetraPanel="#000000";   dis_CId="#CF0000";      dis_CPeso="#FFFFFF";    dis_LetraRec="#000000";
        }else if(modelo==7){
            dis_menu="#FF93A4";             dis_botones="#FF2327";      dis_BarraC1="#DF97FF";  dis_CArtista="#FF0070"; dis_CTiempo="#FF0070";  ImagenBarra="Imagenes/BarraAmor.png";
            dis_panelcambio="#FFD9E6";      dis_LetraBoton="#000000";   dis_BarraC2="#FFBBFC";  dis_CCancion="#FF00D0"; dis_CAlbun="#FF00D0";
            dis_controles="#FF6DFF";        dis_LetraPanel="#000000";   dis_CId="#FF0004";      dis_CPeso="#FF0004";    dis_LetraRec="#000000";
        }
        // Configuración del JFrame principal
        setTitle("ReproductorFrame");
        setSize(1210, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        // Panel p_ReproductoControl (Control)------------------------------------------------------------------------------
        JPanel p_ReproductoControl = new JPanel();
        p_ReproductoControl.setLayout(null);
        p_ReproductoControl.setPreferredSize(new Dimension(1200, 200));
        p_ReproductoControl.setBounds(300, 400, 900, 200);
        p_ReproductoControl.setBackground(Color.decode(dis_controles));
        JLabel tx_Instrucciones1= new JLabel("Estos comandos proporcionan una forma estructurada de buscar y acceder a la música en tu aplicación. Y estos comandos son indispensables ya "), 
                tx_Instrucciones2= new JLabel("que no se puede encontrar música sin ellos."),
                tx_Instrucciones3= new JLabel("BusAl:(nombre del álbum)       Ejemplo: BusAl:Gaia 3                    Este comando se utiliza para buscar canciones de un album."),
                tx_Instrucciones4= new JLabel("BusAr:(nombre del artista)     Ejemplo: BusAr:Mago de Oz                Este comando se utiliza para buscar albums de un artista."),
                tx_Instrucciones5= new JLabel("BusCa:(nombre del cancion)     Ejemplo: BusCa:Volaverunt opus 666       Este comando se utiliza para buscar canciones especificas."),
                tx_Instrucciones6= new JLabel("Puedes usar los comandos de prueba si no sabes que buscar.");
          // Pocicion (Menu)
        tx_Instrucciones1.setBounds(20, 20, 1000, 20);  tx_Instrucciones2.setBounds(20, 40, 1000, 20);  tx_Instrucciones3.setBounds(20, 75, 1000, 20);
        tx_Instrucciones4.setBounds(20, 95, 1000, 20); tx_Instrucciones5.setBounds(20, 115, 1000, 20);  tx_Instrucciones6.setBounds(20, 135, 1000, 20);
         // Color de letras (Menu)
        tx_Instrucciones1.setForeground(Color.decode(dis_LetraPanel));tx_Instrucciones2.setForeground(Color.decode(dis_LetraPanel));
        tx_Instrucciones3.setForeground(Color.decode(dis_LetraPanel));tx_Instrucciones4.setForeground(Color.decode(dis_LetraPanel));
        tx_Instrucciones5.setForeground(Color.decode(dis_LetraPanel));tx_Instrucciones6.setForeground(Color.decode(dis_LetraPanel));
        // Colocal objetos(Menu)
        p_ReproductoControl.add(tx_Instrucciones1); p_ReproductoControl.add(tx_Instrucciones2); p_ReproductoControl.add(tx_Instrucciones3); 
        p_ReproductoControl.add(tx_Instrucciones4); p_ReproductoControl.add(tx_Instrucciones5); p_ReproductoControl.add(tx_Instrucciones6);
        // Panel p_Menu (Menu)----------------------------------------------------------------------------------------------
        JPanel p_Menu = new JPanel();
        p_Menu.setLayout(null);
        p_Menu.setPreferredSize(new Dimension(300, 600));
        p_Menu.setBounds(0, 0, 300, 600);
        p_Menu.setBackground(Color.decode(dis_menu)); 
        // Componentes del panel (Menu)
        JButton btn_ajustes= new JButton("Opciones"), btn_descarga= new JButton("Canciones"), btn_albumes= new JButton("Albums")
            ,btn_salir= new JButton("Salir"), btn_ir= new JButton(">"), btn_inicio= new JButton("Inicio"); 
        JLabel tx_buscador= new JLabel("Buscador");
        JTextField tf_buscador= new JTextField();
        // Pocicion (Menu)
        btn_ajustes.setBounds(20, 20, 260, 50);     tx_buscador.setBounds(20, 90, 260, 20);     tf_buscador.setBounds(20, 120, 200, 20);
        btn_ir.setBounds(230, 110, 50, 40);         btn_inicio.setBounds(20, 160, 260, 50);     btn_albumes.setBounds(20, 230, 260, 50);
        btn_descarga.setBounds(20, 300, 260, 50);   btn_salir.setBounds(20, 370, 260, 50);
        // Color de fondo (Menu)
        btn_ajustes.setBackground(Color.decode(dis_botones)); btn_ir.setBackground(Color.decode(dis_botones));      btn_descarga.setBackground(Color.decode(dis_botones));
        btn_albumes.setBackground(Color.decode(dis_botones)); btn_salir.setBackground(Color.decode(dis_botones));   btn_inicio.setBackground(Color.decode(dis_botones));
        // Color de letras (Menu)
        btn_ajustes.setForeground(Color.decode(dis_LetraBoton));   tx_buscador.setForeground(Color.decode("#FFFFFF")); btn_ir.setForeground(Color.decode(dis_LetraBoton));
        btn_descarga.setForeground(Color.decode(dis_LetraBoton));  btn_albumes.setForeground(Color.decode(dis_LetraBoton)); btn_salir.setForeground(Color.decode(dis_LetraBoton));
        btn_inicio.setForeground(Color.decode(dis_LetraBoton));
        // Colocal objetos(Menu)
        p_Menu.add(btn_ajustes);    p_Menu.add(tx_buscador); p_Menu.add(tf_buscador);   p_Menu.add(btn_ir); p_Menu.add(btn_descarga);   p_Menu.add(btn_albumes);    p_Menu.add(btn_salir);
        p_Menu.add(btn_inicio);

        // Panel p_Inicio (Inicio)------------------------------------------------------------------------------------------
        JPanel p_Inicio = new JPanel();
        p_Inicio.setLayout(null);
        p_Inicio.setPreferredSize(new Dimension(900, 400));
        p_Inicio.setBounds(300, 0, 900, 400);
        p_Inicio.setBackground(Color.decode(dis_panelcambio));
        // Componentes del panel (Inicio)
        JButton btn_vip= new JButton("VIP");
        JLabel tx_Mp3Re= new JLabel("Mp3 Reproductor FIE"),etiquetaImagen = new JLabel();
        JPanel p_barra= new JPanel(new FlowLayout(FlowLayout.CENTER));   p_barra.setLayout(null);    p_barra.setPreferredSize(new Dimension(900, 100)); 
        // Pocicion (Inicio)
        p_barra.setBounds(0, 150, 900, 100);  btn_vip.setBounds(100, 300, 700, 80);  tx_Mp3Re.setBounds(350, 20, 200, 80);   etiquetaImagen.setBounds(0, 0, 900, 200);
        // Color de fondo (Inicio)
        p_barra.setBackground(Color.decode("#5F5F5F"));/**/     btn_vip.setBackground(Color.decode(dis_botones));   tx_Mp3Re.setForeground(Color.decode(dis_LetraPanel)); 
        // Color de letras (Inicio)
        btn_vip.setForeground(Color.decode(dis_LetraBoton));
        //  Colocar imagen 
        /**/try {
            BufferedImage imagen = ImageIO.read(getClass().getResource(ImagenBarra));

            // Ajustar el tamaño de la imagen (por ejemplo, duplicar su tamaño)
            int nuevoAncho = imagen.getWidth() * 1;
            int nuevoAlto = imagen.getHeight() * 1;
            Image imagenEscalada = imagen.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

            etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p_barra.add(etiquetaImagen); 
        // Colocal objetos(Inicio)
        p_Inicio.add(p_barra);  p_Inicio.add(btn_vip);  p_Inicio.add(tx_Mp3Re);
        // Crea un nuevo objeto Font con un tamaño más grande (por ejemplo, 20)
        Font fuenteGrande = new Font(tx_Mp3Re.getFont().getName(), Font.PLAIN, 20);
        // Establece la nueva fuente en el JLabel
        tx_Mp3Re.setFont(fuenteGrande);

        // Panel p_Albun (Albun)--------------------------------------------------------------------------------------------
        JPanel p_Album = new JPanel();
        p_Album.setLayout(null);
        p_Album.setPreferredSize(new Dimension(900, 400));
        p_Album.setBounds(300, 0, 900, 400);
        p_Album.setBackground(Color.decode(dis_panelcambio));
        // Componentes del panel(Reproductor)
        JLabel tx_Album= new JLabel("Albums de bandas");
        JButton btn_album1= new JButton("Album1"),btn_album2= new JButton("Album2"),btn_album3= new JButton("Album3"),btn_album4= new JButton("Album4"),
            btn_atras= new JButton("<"),btn_siguiente= new JButton(">");
        // Pocicion (Reproductor)
        btn_album1.setBounds(100, 80, 160, 160); btn_album2.setBounds(280, 80, 160, 160);    btn_album3.setBounds(460, 80, 160, 160); btn_album4.setBounds(640, 80, 160, 160);
        btn_atras.setBounds(300, 330, 100, 50);  btn_siguiente.setBounds(500, 330, 100, 50); tx_Album.setBounds(350, 20, 200, 80);
        // Establece la nueva fuente en el JLabel(Reproductor)
        tx_Album.setFont(fuenteGrande);
        // Color de fondo (Reproductor)
        btn_atras.setBackground(Color.decode(dis_botones)); btn_siguiente.setBackground(Color.decode(dis_botones));
        // Color de letras (Reproductor)
        btn_atras.setForeground(Color.decode(dis_LetraBoton));  btn_siguiente.setForeground(Color.decode(dis_LetraBoton));  tx_Album.setForeground(Color.decode(dis_LetraPanel));
        // Colocal objetos (Reproductor)
        p_Album.add(btn_album1);p_Album.add(btn_album2);   p_Album.add(btn_album3);p_Album.add(btn_album4);
        p_Album.add(btn_atras); p_Album.add(btn_siguiente);p_Album.add(tx_Album); /**/

        

        // Panel p_Ajustes (Ajustes)----------------------------------------------------------------------------------------
        JPanel p_Ajustes = new JPanel();
        p_Ajustes.setLayout(null);
        p_Ajustes.setPreferredSize(new Dimension(900, 400));
        p_Ajustes.setBounds(300, 0, 900, 400);
        p_Ajustes.setBackground(Color.decode(dis_panelcambio));
        // componentes del panel(Ajustes)
        JButton btn_cambiodediseño = new JButton("cambiar el diseño");
        JLabel tx_navidad = new JLabel("Nav(diseño navideño)"), tx_halloween = new JLabel("Haw(diseño de halloween)"), tx_amoryamistad = new JLabel("Amor(diseño de San Valentín)"),
               tx_semanasanta = new JLabel("Nor(Modo Normal)"), tx_diadelavirgen = new JLabel("Osc(Modo Oscuro)"),
               tx_diadelamadre = new JLabel("Madre(diseño del dia de las madres)"), tx_independencia = new JLabel("Inde(diseño para el dia de la independencia)");
        JTextField tf_design = new JTextField();
        JTextField tf_url = new JTextField(), tf_titulo = new JTextField(), tf_tamaño = new JTextField(),
                   tf_duracion = new JTextField(), tf_albumpertenece = new JTextField();
        JLabel tx_mensaje = new JLabel("¿Quieres publicar alguna canciòn? Llena los siguientes campos con la informaciòn requerida"), tx_url = new JLabel("Url de la cancion"), tx_titulo = new JLabel("Titulo de la cancion"), 
        tx_tamaño = new JLabel("Peso de la canciòn en MB"), tx_duracion = new JLabel("Duraciòn de la canciòn"), tx_albumpertenece = new JLabel("Album al que pertenece");
        JButton btn_subircancion = new JButton("Publicar canciòn");
        // Pocicion (Ajustes)
        tx_navidad.setBounds(20, 55, 200, 30);          tx_halloween.setBounds(20, 85, 200, 30);        tx_amoryamistad.setBounds(20, 115, 200, 30);
        tx_semanasanta.setBounds(280, 55, 200, 30);     tx_diadelavirgen.setBounds(280, 85, 200, 30);   tx_diadelamadre.setBounds(580, 55, 250, 30);
        tx_independencia.setBounds(580, 85, 250, 30);   tf_design.setBounds(20, 20, 350, 30);           btn_cambiodediseño.setBounds(500, 20, 340, 30);
        tx_url.setBounds(180, 185, 200, 30);            tx_titulo.setBounds(180, 215, 200, 30);         tx_tamaño.setBounds(180, 245, 200, 30);
        tx_duracion.setBounds(180, 275, 200, 30);       tx_albumpertenece.setBounds(180, 305, 200, 30); tx_mensaje.setBounds(192, 155, 550, 30);
        tf_url.setBounds(350, 185, 390, 20);            tf_titulo.setBounds(350, 215, 390, 20);         tf_tamaño.setBounds(350, 245, 390, 20);         
        tf_duracion.setBounds(350, 275, 390, 20);       tf_albumpertenece.setBounds(350, 305, 390, 20); btn_subircancion.setBounds(250, 345, 400, 30);
        // Color de fondo (Ajustes)
        btn_cambiodediseño.setBackground(Color.decode(dis_botones));    btn_subircancion.setBackground(Color.decode(dis_botones));
        // Color de letras (Ajustes)
        btn_cambiodediseño.setForeground(Color.decode(dis_LetraBoton));  
        tx_navidad.setForeground(Color.decode(dis_LetraPanel));             tx_halloween.setForeground(Color.decode(dis_LetraPanel));           tx_amoryamistad.setForeground(Color.decode(dis_LetraPanel));
        tx_semanasanta.setForeground(Color.decode(dis_LetraPanel));         tx_diadelavirgen.setForeground(Color.decode(dis_LetraPanel));       tx_diadelamadre.setForeground(Color.decode(dis_LetraPanel));
        tx_independencia.setForeground(Color.decode(dis_LetraPanel));       btn_subircancion.setForeground(Color.decode(dis_LetraBoton));
        tx_url.setForeground(Color.decode(dis_LetraPanel));                 tx_titulo.setForeground(Color.decode(dis_LetraPanel));              tx_tamaño.setForeground(Color.decode(dis_LetraPanel));
        tx_duracion.setForeground(Color.decode(dis_LetraPanel));            tx_albumpertenece.setForeground(Color.decode(dis_LetraPanel));      tx_mensaje.setForeground(Color.decode(dis_LetraPanel)); 
        // Colocal objetos (Ajustes)
        p_Ajustes.add(btn_cambiodediseño);  p_Ajustes.add(tx_navidad);      p_Ajustes.add(tx_halloween);    p_Ajustes.add(tx_amoryamistad); p_Ajustes.add(tx_semanasanta);
        p_Ajustes.add(tx_diadelavirgen);    p_Ajustes.add(tx_diadelamadre); p_Ajustes.add(tx_independencia);p_Ajustes.add(tf_design);
        p_Ajustes.add(tx_url);              p_Ajustes.add(tx_titulo);       p_Ajustes.add(tx_tamaño);       p_Ajustes.add(tx_duracion);     p_Ajustes.add(tx_albumpertenece);
        p_Ajustes.add(tf_url);              p_Ajustes.add(tf_titulo);       p_Ajustes.add(tf_tamaño);       p_Ajustes.add(tf_duracion);     p_Ajustes.add(tf_albumpertenece);
        p_Ajustes.add(btn_subircancion);    p_Ajustes.add(tx_mensaje);
    
        // Panel p_Reproductor (Reproductor)--------------------------------------------------------------------------------
        JPanel p_Reproductor = new JPanel();
        p_Reproductor.setLayout(null);
        p_Reproductor.setPreferredSize(new Dimension(900, 400));
        p_Reproductor.setBounds(300, 0, 900, 400);
        p_Reproductor.setBackground(Color.decode(dis_panelcambio));
        // Componentes del panel(Reproductor)
        JLabel tx_id= new JLabel("ID", SwingConstants.CENTER), tx_artista= new JLabel("Artista", SwingConstants.CENTER),tx_cancion= new JLabel("Cancion", SwingConstants.CENTER),
            tx_peso= new JLabel("Peso", SwingConstants.CENTER), tx_tiempo= new JLabel("Tiempo", SwingConstants.CENTER), tx_albun= new JLabel("Albun", SwingConstants.CENTER);
        tx_id.setOpaque(true);      tx_artista.setOpaque(true); tx_cancion.setOpaque(true);
        tx_peso.setOpaque(true);    tx_tiempo.setOpaque(true);  tx_albun.setOpaque(true);
        JLabel tx_id1=new JLabel("1"),tx_artista1=new JLabel("artista1"),tx_cancion1= new JLabel("Cancion1"),tx_peso1= new JLabel("Peso1"), tx_tiempo1= new JLabel("Tiempo1"), tx_albun1= new JLabel("Albun1"),
            tx_id2=new JLabel("2"),tx_artista2=new JLabel("artista2"),tx_cancion2= new JLabel("Cancion2"),tx_peso2= new JLabel("Peso2"), tx_tiempo2= new JLabel("Tiempo2"), tx_albun2= new JLabel("Albun2"),
            tx_id3=new JLabel("3"),tx_artista3=new JLabel("artista3"),tx_cancion3= new JLabel("Cancion3"),tx_peso3= new JLabel("Peso3"), tx_tiempo3= new JLabel("Tiempo3"), tx_albun3= new JLabel("Albun3"),
            tx_id4=new JLabel("4"),tx_artista4=new JLabel("artista4"),tx_cancion4= new JLabel("Cancion4"),tx_peso4= new JLabel("Peso4"), tx_tiempo4= new JLabel("Tiempo4"), tx_albun4= new JLabel("Albun4"),
            tx_id5=new JLabel("5"),tx_artista5=new JLabel("artista5"),tx_cancion5= new JLabel("Cancion5"),tx_peso5= new JLabel("Peso5"), tx_tiempo5= new JLabel("Tiempo5"), tx_albun5= new JLabel("Albun5"),
            tx_id6=new JLabel("6"),tx_artista6=new JLabel("artista6"),tx_cancion6= new JLabel("Cancion6"),tx_peso6= new JLabel("Peso6"), tx_tiempo6= new JLabel("Tiempo6"), tx_albun6= new JLabel("Albun6"),
            tx_id7=new JLabel("7"),tx_artista7=new JLabel("artista7"),tx_cancion7= new JLabel("Cancion7"),tx_peso7= new JLabel("Peso7"), tx_tiempo7= new JLabel("Tiempo7"), tx_albun7= new JLabel("Albun7"),
            tx_id8=new JLabel("8"),tx_artista8=new JLabel("artista8"),tx_cancion8= new JLabel("Cancion8"),tx_peso8= new JLabel("Peso8"), tx_tiempo8= new JLabel("Tiempo8"), tx_albun8= new JLabel("Albun8"),
            tx_id9=new JLabel("9"),tx_artista9=new JLabel("artista9"),tx_cancion9= new JLabel("Cancion9"),tx_peso9= new JLabel("Peso9"), tx_tiempo9= new JLabel("Tiempo9"), tx_albun9= new JLabel("Albun9"),
            tx_id10=new JLabel("10"),tx_artista10=new JLabel("artista10"),tx_cancion10= new JLabel("Cancion10"),tx_peso10= new JLabel("Peso10"), tx_tiempo10= new JLabel("Tiempo10"), tx_albun10= new JLabel("Albun10");
        tx_id1.setOpaque(true); tx_artista1.setOpaque(true); tx_cancion1.setOpaque(true); tx_peso1.setOpaque(true); tx_tiempo1.setOpaque(true); tx_albun1.setOpaque(true);
        tx_id2.setOpaque(true); tx_artista2.setOpaque(true); tx_cancion2.setOpaque(true); tx_peso2.setOpaque(true); tx_tiempo2.setOpaque(true); tx_albun2.setOpaque(true);
        tx_id3.setOpaque(true); tx_artista3.setOpaque(true); tx_cancion3.setOpaque(true); tx_peso3.setOpaque(true); tx_tiempo3.setOpaque(true); tx_albun3.setOpaque(true);
        tx_id4.setOpaque(true); tx_artista4.setOpaque(true); tx_cancion4.setOpaque(true); tx_peso4.setOpaque(true); tx_tiempo4.setOpaque(true); tx_albun4.setOpaque(true);
        tx_id5.setOpaque(true); tx_artista5.setOpaque(true); tx_cancion5.setOpaque(true); tx_peso5.setOpaque(true); tx_tiempo5.setOpaque(true); tx_albun5.setOpaque(true);
        tx_id6.setOpaque(true); tx_artista6.setOpaque(true); tx_cancion6.setOpaque(true); tx_peso6.setOpaque(true); tx_tiempo6.setOpaque(true); tx_albun6.setOpaque(true);
        tx_id7.setOpaque(true); tx_artista7.setOpaque(true); tx_cancion7.setOpaque(true); tx_peso7.setOpaque(true); tx_tiempo7.setOpaque(true); tx_albun7.setOpaque(true);
        tx_id8.setOpaque(true); tx_artista8.setOpaque(true); tx_cancion8.setOpaque(true); tx_peso8.setOpaque(true); tx_tiempo8.setOpaque(true); tx_albun8.setOpaque(true);
        tx_id9.setOpaque(true); tx_artista9.setOpaque(true); tx_cancion9.setOpaque(true); tx_peso9.setOpaque(true); tx_tiempo9.setOpaque(true); tx_albun9.setOpaque(true);
        tx_id10.setOpaque(true);tx_artista10.setOpaque(true);tx_cancion10.setOpaque(true);tx_peso10.setOpaque(true);tx_tiempo10.setOpaque(true);tx_albun10.setOpaque(true);
        JButton btn_siguienteR= new JButton("Siguiente >"),btn_atrasR= new JButton("< Atras"), btn_music1=new JButton(">"), btn_music2=new JButton(">"), btn_music3=new JButton(">"), btn_music4=new JButton(">"), 
                btn_music5=new JButton(">"), btn_music6=new JButton(">"), btn_music7=new JButton(">"), btn_music8=new JButton(">"), btn_music9=new JButton(">"), btn_music10=new JButton(">");
        // Pocicion (Reproductor)
        tx_id.setBounds(20, 20, 50, 20);    tx_artista.setBounds(70, 20, 200, 20);  tx_cancion.setBounds(270, 20, 210, 20);
        tx_peso.setBounds(480, 20, 100, 20);tx_tiempo.setBounds(580, 20, 100, 20);  tx_albun.setBounds(680, 20, 200, 20);
        btn_atrasR.setBounds(100, 330, 200, 50); btn_siguienteR.setBounds(600, 330, 200, 50); 
        tx_id1.setBounds(20,40,50,20);   tx_artista1.setBounds(70,40,200,20);  tx_cancion1.setBounds(270,40,210,20);  tx_peso1.setBounds(480,40, 100, 20);  tx_tiempo1.setBounds(580,40,100,20);  tx_albun1.setBounds(680,40,100,20);   btn_music1.setBounds(780,40,100,20);
        tx_id2.setBounds(20,60,50,20);   tx_artista2.setBounds(70,60,200,20);  tx_cancion2.setBounds(270,60,210,20);  tx_peso2.setBounds(480,60, 100, 20);  tx_tiempo2.setBounds(580,60,100,20);  tx_albun2.setBounds(680,60,200,20);   btn_music2.setBounds(780,60,100,20);    
        tx_id3.setBounds(20,80,50,20);   tx_artista3.setBounds(70,80,200,20);  tx_cancion3.setBounds(270,80,210,20);  tx_peso3.setBounds(480,80, 100, 20);  tx_tiempo3.setBounds(580,80,100,20);  tx_albun3.setBounds(680,80,200,20);   btn_music3.setBounds(780,80,100,20);
        tx_id4.setBounds(20,100,50,20);  tx_artista4.setBounds(70,100,200,20); tx_cancion4.setBounds(270,100,210,20); tx_peso4.setBounds(480,100, 100, 20); tx_tiempo4.setBounds(580,100,100,20); tx_albun4.setBounds(680,100,200,20);  btn_music4.setBounds(780,100,100,20);
        tx_id5.setBounds(20,120,50,20);  tx_artista5.setBounds(70,120,200,20); tx_cancion5.setBounds(270,120,210,20); tx_peso5.setBounds(480,120, 100, 20); tx_tiempo5.setBounds(580,120,100,20); tx_albun5.setBounds(680,120,200,20);  btn_music5.setBounds(780,120,100,20);
        tx_id6.setBounds(20,140,50,20);  tx_artista6.setBounds(70,140,200,20); tx_cancion6.setBounds(270,140,210,20); tx_peso6.setBounds(480,140, 100, 20); tx_tiempo6.setBounds(580,140,100,20); tx_albun6.setBounds(680,140,200,20);  btn_music6.setBounds(780,140,100,20);
        tx_id7.setBounds(20,160,50,20);  tx_artista7.setBounds(70,160,200,20); tx_cancion7.setBounds(270,160,210,20); tx_peso7.setBounds(480,160, 100, 20); tx_tiempo7.setBounds(580,160,100,20); tx_albun7.setBounds(680,160,200,20);  btn_music7.setBounds(780,160,100,20);
        tx_id8.setBounds(20,180,50,20);  tx_artista8.setBounds(70,180,200,20); tx_cancion8.setBounds(270,180,210,20); tx_peso8.setBounds(480,180, 100, 20); tx_tiempo8.setBounds(580,180,100,20); tx_albun8.setBounds(680,180,200,20);  btn_music8.setBounds(780,180,100,20);
        tx_id9.setBounds(20,200,50,20);  tx_artista9.setBounds(70,200,200,20); tx_cancion9.setBounds(270,200,210,20); tx_peso9.setBounds(480,200, 100, 20); tx_tiempo9.setBounds(580,200,100,20); tx_albun9.setBounds(680,200,200,20);  btn_music9.setBounds(780,200,100,20);
        tx_id10.setBounds(20,220,50,20); tx_artista10.setBounds(70,220,200,20);tx_cancion10.setBounds(270,220,210,20);tx_peso10.setBounds(480,220, 100, 20);tx_tiempo10.setBounds(580,220,100,20);tx_albun10.setBounds(680,220,200,20); btn_music10.setBounds(780,220,100,20);
        // Color de fondo (Reproductor)
        tx_id.setBackground(Color.decode(dis_CId));     tx_artista.setBackground(Color.decode(dis_CArtista));   tx_cancion.setBackground(Color.decode(dis_CCancion));
        tx_peso.setBackground(Color.decode(dis_CPeso)); tx_tiempo.setBackground(Color.decode(dis_CTiempo));     tx_albun.setBackground(Color.decode(dis_CAlbun));
        btn_atrasR.setBackground(Color.decode(dis_botones)); btn_siguienteR.setBackground(Color.decode(dis_botones));
        tx_id1.setBackground(Color.decode(dis_BarraC1)); tx_artista1.setBackground(Color.decode(dis_BarraC1));  tx_cancion1.setBackground(Color.decode(dis_BarraC1));  tx_peso1.setBackground(Color.decode(dis_BarraC1));  tx_tiempo1.setBackground(Color.decode(dis_BarraC1));  tx_albun1.setBackground(Color.decode(dis_BarraC1));    btn_music1.setBackground(Color.decode(dis_botones));
        tx_id2.setBackground(Color.decode(dis_BarraC2)); tx_artista2.setBackground(Color.decode(dis_BarraC2));  tx_cancion2.setBackground(Color.decode(dis_BarraC2));  tx_peso2.setBackground(Color.decode(dis_BarraC2));  tx_tiempo2.setBackground(Color.decode(dis_BarraC2));  tx_albun2.setBackground(Color.decode(dis_BarraC2));    btn_music2.setBackground(Color.decode(dis_botones));
        tx_id3.setBackground(Color.decode(dis_BarraC1)); tx_artista3.setBackground(Color.decode(dis_BarraC1));  tx_cancion3.setBackground(Color.decode(dis_BarraC1));  tx_peso3.setBackground(Color.decode(dis_BarraC1));  tx_tiempo3.setBackground(Color.decode(dis_BarraC1));  tx_albun3.setBackground(Color.decode(dis_BarraC1));    btn_music3.setBackground(Color.decode(dis_botones));
        tx_id4.setBackground(Color.decode(dis_BarraC2)); tx_artista4.setBackground(Color.decode(dis_BarraC2));  tx_cancion4.setBackground(Color.decode(dis_BarraC2));  tx_peso4.setBackground(Color.decode(dis_BarraC2));  tx_tiempo4.setBackground(Color.decode(dis_BarraC2));  tx_albun4.setBackground(Color.decode(dis_BarraC2));    btn_music4.setBackground(Color.decode(dis_botones));
        tx_id5.setBackground(Color.decode(dis_BarraC1)); tx_artista5.setBackground(Color.decode(dis_BarraC1));  tx_cancion5.setBackground(Color.decode(dis_BarraC1));  tx_peso5.setBackground(Color.decode(dis_BarraC1));  tx_tiempo5.setBackground(Color.decode(dis_BarraC1));  tx_albun5.setBackground(Color.decode(dis_BarraC1));    btn_music5.setBackground(Color.decode(dis_botones));
        tx_id6.setBackground(Color.decode(dis_BarraC2)); tx_artista6.setBackground(Color.decode(dis_BarraC2));  tx_cancion6.setBackground(Color.decode(dis_BarraC2));  tx_peso6.setBackground(Color.decode(dis_BarraC2));  tx_tiempo6.setBackground(Color.decode(dis_BarraC2));  tx_albun6.setBackground(Color.decode(dis_BarraC2));    btn_music6.setBackground(Color.decode(dis_botones));
        tx_id7.setBackground(Color.decode(dis_BarraC1)); tx_artista7.setBackground(Color.decode(dis_BarraC1));  tx_cancion7.setBackground(Color.decode(dis_BarraC1));  tx_peso7.setBackground(Color.decode(dis_BarraC1));  tx_tiempo7.setBackground(Color.decode(dis_BarraC1));  tx_albun7.setBackground(Color.decode(dis_BarraC1));    btn_music7.setBackground(Color.decode(dis_botones));    
        tx_id8.setBackground(Color.decode(dis_BarraC2)); tx_artista8.setBackground(Color.decode(dis_BarraC2));  tx_cancion8.setBackground(Color.decode(dis_BarraC2));  tx_peso8.setBackground(Color.decode(dis_BarraC2));  tx_tiempo8.setBackground(Color.decode(dis_BarraC2));  tx_albun8.setBackground(Color.decode(dis_BarraC2));    btn_music8.setBackground(Color.decode(dis_botones));
        tx_id9.setBackground(Color.decode(dis_BarraC1)); tx_artista9.setBackground(Color.decode(dis_BarraC1));  tx_cancion9.setBackground(Color.decode(dis_BarraC1));  tx_peso9.setBackground(Color.decode(dis_BarraC1));  tx_tiempo9.setBackground(Color.decode(dis_BarraC1));  tx_albun9.setBackground(Color.decode(dis_BarraC1));    btn_music9.setBackground(Color.decode(dis_botones));
        tx_id10.setBackground(Color.decode(dis_BarraC2));tx_artista10.setBackground(Color.decode(dis_BarraC2)); tx_cancion10.setBackground(Color.decode(dis_BarraC2)); tx_peso10.setBackground(Color.decode(dis_BarraC2)); tx_tiempo10.setBackground(Color.decode(dis_BarraC2)); tx_albun10.setBackground(Color.decode(dis_BarraC2));   btn_music10.setBackground(Color.decode(dis_botones));
        // Color de letras (Reproductor)
        tx_id.setForeground(Color.decode(dis_LetraRec));        tx_artista.setForeground(Color.decode(dis_LetraRec));          tx_cancion.setForeground(Color.decode(dis_LetraRec));
        tx_peso.setForeground(Color.decode(dis_LetraRec));      tx_tiempo.setForeground(Color.decode(dis_LetraRec));           tx_albun.setForeground(Color.decode(dis_LetraRec));
        btn_atrasR.setForeground(Color.decode(dis_LetraBoton)); btn_siguienteR.setForeground(Color.decode(dis_LetraBoton));    
        // Colocal objetos (Reproductor)
        p_Reproductor.add(tx_id);  p_Reproductor.add(tx_artista);  p_Reproductor.add(tx_cancion);  p_Reproductor.add(tx_peso);  p_Reproductor.add(tx_tiempo);  p_Reproductor.add(tx_albun);
        p_Reproductor.add(btn_siguienteR);   p_Reproductor.add(btn_atrasR);
        p_Reproductor.add(tx_id1); p_Reproductor.add(tx_artista1); p_Reproductor.add(tx_cancion1); p_Reproductor.add(tx_peso1); p_Reproductor.add(tx_tiempo1); p_Reproductor.add(tx_albun1);    p_Reproductor.add(btn_music1);
        p_Reproductor.add(tx_id2); p_Reproductor.add(tx_artista2); p_Reproductor.add(tx_cancion2); p_Reproductor.add(tx_peso2); p_Reproductor.add(tx_tiempo2); p_Reproductor.add(tx_albun2);    p_Reproductor.add(btn_music2);
        p_Reproductor.add(tx_id3); p_Reproductor.add(tx_artista3); p_Reproductor.add(tx_cancion3); p_Reproductor.add(tx_peso3); p_Reproductor.add(tx_tiempo3); p_Reproductor.add(tx_albun3);    p_Reproductor.add(btn_music3);
        p_Reproductor.add(tx_id4); p_Reproductor.add(tx_artista4); p_Reproductor.add(tx_cancion4); p_Reproductor.add(tx_peso4); p_Reproductor.add(tx_tiempo4); p_Reproductor.add(tx_albun4);    p_Reproductor.add(btn_music4);  
        p_Reproductor.add(tx_id5); p_Reproductor.add(tx_artista5); p_Reproductor.add(tx_cancion5); p_Reproductor.add(tx_peso5); p_Reproductor.add(tx_tiempo5); p_Reproductor.add(tx_albun5);    p_Reproductor.add(btn_music5);
        p_Reproductor.add(tx_id6); p_Reproductor.add(tx_artista6); p_Reproductor.add(tx_cancion6); p_Reproductor.add(tx_peso6); p_Reproductor.add(tx_tiempo6); p_Reproductor.add(tx_albun6);    p_Reproductor.add(btn_music6);  
        p_Reproductor.add(tx_id7); p_Reproductor.add(tx_artista7); p_Reproductor.add(tx_cancion7); p_Reproductor.add(tx_peso7); p_Reproductor.add(tx_tiempo7); p_Reproductor.add(tx_albun7);    p_Reproductor.add(btn_music7);
        p_Reproductor.add(tx_id8); p_Reproductor.add(tx_artista8); p_Reproductor.add(tx_cancion8); p_Reproductor.add(tx_peso8); p_Reproductor.add(tx_tiempo8); p_Reproductor.add(tx_albun8);    p_Reproductor.add(btn_music8);
        p_Reproductor.add(tx_id9); p_Reproductor.add(tx_artista9); p_Reproductor.add(tx_cancion9); p_Reproductor.add(tx_peso9); p_Reproductor.add(tx_tiempo9); p_Reproductor.add(tx_albun9);    p_Reproductor.add(btn_music9);
        p_Reproductor.add(tx_id10);p_Reproductor.add(tx_artista10);p_Reproductor.add(tx_cancion10);p_Reproductor.add(tx_peso10);p_Reproductor.add(tx_tiempo10);p_Reproductor.add(tx_albun10);   p_Reproductor.add(btn_music10);

        // Colocal objetos(framer)---------------
        add(p_Menu);
        add(p_ReproductoControl);
        add(p_Inicio);
        // Variables---------------------------------------------------------------------------------------------------------
        p_Actual=p_Inicio;
        // Manejadores de eventos para los botones---------------------------------------------------------------------------
        // Botones(Menu)++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar el botón "Entrar"
                dispose(); // Cierra el frame actual
                new LoginFrame().setVisible(true); // Abre el nuevo frame
            }
        });
        btn_descarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Reproductor, p_Actual);
            }
        });
        btn_albumes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Paneles a=new Paneles();
                JPanel p_Albun=a.Albun();*/
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Album, p_Actual);
            }
        });
        btn_ir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf_buscador.getText().length() >= 6 && tf_buscador.getText().startsWith("BusAl:")){
                    Controlador ir=new Controlador(tf_buscador.getText());
                    String Information[][]=new String[10][6];
                    Information=ir.searchesAlbum();
                    for (int x = 0; x < Information.length; x++) {
                        // Recorrer las columnas para cada fila
                        System.out.println(Information[x][0]
                            + " | " + Information[x][1]
                            + " | " + Information[x][2]
                            + " | " + Information[x][3]
                            + " | " + Information[x][4]
                            + " | " + Information[x][5]
                        );
                    }    
                    String separador = "BusAl:";
                    refernsiaAl = tf_buscador.getText().substring(tf_buscador.getText().indexOf(separador) + separador.length());
                    minimo=0;
                    System.out.println(refernsiaAl);
                    direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                    direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                    tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                    tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                    tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                    tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                    tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                    tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                    tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                    tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                    tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                    tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    p_Actual=cambiarPanel(p_Reproductor, p_Actual);
                }
                else if(tf_buscador.getText().length() >= 6 && tf_buscador.getText().startsWith("BusAr:")){
                    Controlador ir=new Controlador(tf_buscador.getText(), 0, 4);String separador = "BusAr:";
                    refernsiaAr = tf_buscador.getText().substring(tf_buscador.getText().indexOf(separador) + separador.length());
                    String Information[]=new String[4];
                    Information=ir.searchesArtista();
                    for (int x = 0; x < Information.length; x++) {
                        // Recorrer las columnas para cada fila
                        System.out.println(Information[x]);
                    }minimoAl=0;
                    System.out.println(refernsiaAr);
                    btn_album1.setText(Information[0]);btn_album2.setText(Information[1]);btn_album3.setText(Information[2]);btn_album4.setText(Information[3]);
                    t_album1=Information[0];    t_album2=Information[1];    t_album3=Information[2];    t_album4=Information[3];
                    p_Actual=cambiarPanel(p_Album, p_Actual);
                }
                else if(tf_buscador.getText().length() >= 6 && tf_buscador.getText().startsWith("BusCa:")){
                    System.out.println("Busca una cancion");
                    Controlador ir=new Controlador(tf_buscador.getText());
                    String Information[][]=new String[10][6];
                    Information=ir.searchesCancion();
                    for (int x = 0; x < Information.length; x++) {
                        // Recorrer las columnas para cada fila
                        System.out.println(Information[x][0]
                            + " | " + Information[x][1]
                            + " | " + Information[x][2]
                            + " | " + Information[x][3]
                            + " | " + Information[x][4]
                            + " | " + Information[x][5]
                        );
                    }
                    
                    refernsiaAl ="";
                    minimo=0;
                    System.out.println(refernsiaAl);
                    direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                    direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                    tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                    tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                    tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                    tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                    tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                    tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                    tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                    tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                    tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                    tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);  
                    p_Actual=cambiarPanel(p_Reproductor, p_Actual);
                }
            }
        });
        btn_inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Inicio, p_Actual);
            }
        });
        btn_ajustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Ajustes, p_Actual);
            }
        });
        // Botones(Albun)+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        btn_album1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refernsiaAl=t_album1;
                if (!refernsiaAl.equals("")) {
                    String Information[][]=new String[10][6];
                    Controlador aumento=new Controlador(refernsiaAl, 0, 10);
                    Information=aumento.Albums();
                    
                    minimo=0;
                    System.out.println(minimo);
                    direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                    direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                    tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                    tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                    tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                    tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                    tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                    tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                    tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                    tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                    tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                    tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    
                }else{System.out.println("La variabla albun esta bacio");}
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Reproductor, p_Actual);
                
            }
        });
        btn_album2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refernsiaAl=t_album2;
                if (!refernsiaAl.equals("")) {
                    String Information[][]=new String[10][6];
                    Controlador aumento=new Controlador(refernsiaAl, 0, 10);
                    Information=aumento.Albums();
                    
                    minimo=0;
                    System.out.println(minimo);
                    direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                    direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                    tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                    tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                    tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                    tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                    tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                    tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                    tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                    tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                    tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                    tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    
                }else{System.out.println("La variabla albun esta bacio");}
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Reproductor, p_Actual);
                
            }
        });
        btn_album3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refernsiaAl=t_album3;
                if (!refernsiaAl.equals("")) {
                    String Information[][]=new String[10][6];
                    Controlador aumento=new Controlador(refernsiaAl, 0, 10);
                    Information=aumento.Albums();
                    
                    minimo=0;
                    System.out.println(minimo);
                    direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                    direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                    tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                    tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                    tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                    tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                    tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                    tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                    tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                    tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                    tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                    tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    
                }else{System.out.println("La variabla albun esta bacio");}
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Reproductor, p_Actual);
                
            }
        });
        btn_album4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refernsiaAl=t_album4;
                if (!refernsiaAl.equals("")) {
                    String Information[][]=new String[10][6];
                    Controlador aumento=new Controlador(refernsiaAl, 0, 10);
                    Information=aumento.Albums();
                    
                    minimo=0;
                    System.out.println(minimo);
                    direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                    direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                    tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                    tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                    tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                    tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                    tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                    tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                    tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                    tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                    tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                    tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    
                }else{System.out.println("La variabla albun esta bacio");}
                // Cambia al panel de descarga al hacer clic en el botón
                p_Actual=cambiarPanel(p_Reproductor, p_Actual);
                
            }
        });
        btn_siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!refernsiaAr.equals("")) {
                    Controlador ir=new Controlador(refernsiaAr, minimoAl, 4);
                    String Information[]=new String[4];
                    Information=ir.VerificacionAumentoAr();
                    for (int x = 0; x < Information.length; x++) {
                        // Recorrer las columnas para cada fila
                        System.out.println(Information[x]);
                    }
                    if (!Information[0].equals("No lo logro")) {
                        minimoAl=minimoAl+4;
                        System.out.println(refernsiaAr);
                        btn_album1.setText(Information[0]);btn_album2.setText(Information[1]);btn_album3.setText(Information[2]);btn_album4.setText(Information[3]);
                        t_album1=Information[0];    t_album2=Information[1];    t_album3=Information[2];    t_album4=Information[3]; 
                    } else {
                        System.out.println("Esta vacio");
                        System.out.println(minimoAl);
                    } 
                }else{System.out.println("La variabla albun esta bacio");}
                // Cambia al panel de descarga al hacer clic en el botón
                
            }
        });
        btn_atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!refernsiaAr.equals("")) {
                    Controlador ir=new Controlador(refernsiaAr, minimoAl, 4);
                    String Information[]=new String[4];
                    Information=ir.VerificacionDecrementoAr();
                    for (int x = 0; x < Information.length; x++) {
                        // Recorrer las columnas para cada fila
                        System.out.println(Information[x]);
                    }
                    if (!Information[0].equals("No lo logro")) {
                        minimoAl=minimoAl-4;
                        System.out.println(refernsiaAr);
                        btn_album1.setText(Information[0]);btn_album2.setText(Information[1]);btn_album3.setText(Information[2]);btn_album4.setText(Information[3]);
                        t_album1=Information[0];    t_album2=Information[1];    t_album3=Information[2];    t_album4=Information[3]; 
                    } else {
                        System.out.println("Esta vacio");
                        System.out.println(minimoAl);
                    } 
                }else{System.out.println("La variabla albun esta bacio");}
                // Cambia al panel de descarga al hacer clic en el botón
                
            }
        });
        // Botones(Ajustes)+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        btn_cambiodediseño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo= tf_design.getText();
                
                if(modelo.equals("Nor")){
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(1, Correo).setVisible(true); // Abre el nuevo frame
                }else if(modelo.equals("Nav")){  
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(2,Correo).setVisible(true); // Abre el nuevo frame
                }else if(modelo.equals("Madre")){  
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(3,Correo).setVisible(true); // Abre el nuevo frame
                }else if(modelo.equals("Haw")){  
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(4, Correo).setVisible(true); // Abre el nuevo frame
                }else if(modelo.equals("Osc")){  
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(5, Correo).setVisible(true); // Abre el nuevo frame
                }else if(modelo.equals("Inde")){  
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(6, Correo).setVisible(true); // Abre el nuevo frame
                }else if(modelo.equals("Amor")){  
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(7, Correo).setVisible(true); // Abre el nuevo frame
                }

            }
        });
        btn_subircancion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador subir=new Controlador(Correo, tf_url.getText(), tf_tamaño.getText(), tf_duracion.getText(), tf_titulo.getText(), tf_albumpertenece.getText());
                String Respuespuesta;
                Respuespuesta=subir.SubirCancion();


            }
        });
        // Botones(Reproductor)+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        btn_music1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion1;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion2;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion3;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion4;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion5;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion6;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion7;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion8;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion9;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_music10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direcion=direccion10;
                //String direcion="https://edgaralan568.000webhostapp.com/Practica/sound/sont.mp3";
                MP3 rep=new MP3(direcion);
                rep.play();
                
            }
        });
        btn_siguienteR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!refernsiaAl.equals("")) {
                    String Information[][]=new String[10][6];
                    Controlador aumento=new Controlador(refernsiaAl, minimo);
                    Information=aumento.VerificacionAumento();
                    if (!Information[0][0].equals("No lo logro")) {
                        minimo=minimo+10;
                        System.out.println(minimo);
                        direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                        direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                        tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                        tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                        tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                        tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                        tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                        tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                        tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                        tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                        tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                        tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    } else {
                        System.out.println("Esta vacio");
                        System.out.println(minimo);
                    }
                }else{System.out.println("La variabla albun esta bacio");}
            }
        });
        btn_atrasR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!refernsiaAl.equals("")) {
                    String Information[][]=new String[10][6];
                    Controlador aumento=new Controlador(refernsiaAl, minimo);
                    Information=aumento.VerificacionDecremento();
                    if (!Information[0][0].equals("No lo logro")) {
                        minimo=minimo-10;
                        System.out.println(minimo);
                        direccion1="musica/"+Information[0][0]; direccion2="musica/"+Information[1][0]; direccion3="musica/"+Information[2][0]; direccion4="musica/"+Information[3][0]; direccion5="musica/"+Information[4][0];
                        direccion6="musica/"+Information[5][0]; direccion7="musica/"+Information[6][0]; direccion8="musica/"+Information[7][0]; direccion9="musica/"+Information[8][0]; direccion10="musica/"+Information[9][0];
                        tx_id1.setText("1");     tx_artista1.setText(Information[0][1]);  tx_cancion1.setText(Information[0][3]); tx_peso1.setText(Information[0][4]);  tx_tiempo1.setText(Information[0][5]);  tx_albun1.setText(Information[0][2]);
                        tx_id2.setText("2");     tx_artista2.setText(Information[1][1]);  tx_cancion2.setText(Information[1][3]); tx_peso2.setText(Information[1][4]);  tx_tiempo2.setText(Information[1][5]);  tx_albun2.setText(Information[1][2]);
                        tx_id3.setText("3");     tx_artista3.setText(Information[2][1]);  tx_cancion3.setText(Information[2][3]); tx_peso3.setText(Information[2][4]);  tx_tiempo3.setText(Information[2][5]);  tx_albun3.setText(Information[2][2]);
                        tx_id4.setText("4");     tx_artista4.setText(Information[3][1]);  tx_cancion4.setText(Information[3][3]); tx_peso4.setText(Information[3][4]);  tx_tiempo4.setText(Information[3][5]);  tx_albun4.setText(Information[3][2]);
                        tx_id5.setText("5");     tx_artista5.setText(Information[4][1]);  tx_cancion5.setText(Information[4][3]); tx_peso5.setText(Information[4][4]);  tx_tiempo5.setText(Information[4][5]);  tx_albun5.setText(Information[4][2]);
                        tx_id6.setText("6");     tx_artista6.setText(Information[5][1]);  tx_cancion6.setText(Information[5][3]); tx_peso6.setText(Information[5][4]);  tx_tiempo6.setText(Information[5][5]);  tx_albun6.setText(Information[5][2]);
                        tx_id7.setText("7");     tx_artista7.setText(Information[6][1]);  tx_cancion7.setText(Information[6][3]); tx_peso7.setText(Information[6][4]);  tx_tiempo7.setText(Information[6][5]);  tx_albun7.setText(Information[6][2]);
                        tx_id8.setText("8");     tx_artista8.setText(Information[7][1]);  tx_cancion8.setText(Information[7][3]); tx_peso8.setText(Information[7][4]);  tx_tiempo8.setText(Information[7][5]);  tx_albun8.setText(Information[7][2]);
                        tx_id9.setText("9");     tx_artista9.setText(Information[8][1]);  tx_cancion9.setText(Information[8][3]); tx_peso9.setText(Information[8][4]);  tx_tiempo9.setText(Information[8][5]);  tx_albun9.setText(Information[8][2]);
                        tx_id10.setText("10");   tx_artista10.setText(Information[9][1]); tx_cancion10.setText(Information[9][3]);tx_peso10.setText(Information[9][4]); tx_tiempo10.setText(Information[9][5]); tx_albun10.setText(Information[9][2]);
                    } else {
                        System.out.println("Ya no hay mas");
                        System.out.println(minimo);
                    }
                }else{System.out.println("La variabla albun esta bacio");}
            }
        });

        setVisible(true);
    }
    /* 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            
            public void run() {
                String correo="Mago_de_Oz@gmail.com";
                new ReproductorFrame(5, correo);
            }
        });
    }*/
    public JPanel cambiarPanel(JPanel nuevoPanel, JPanel actualPanel) {
        // Remueve el panel actual (p_Reproductor) y agrega el nuevo panel
        remove(actualPanel);
        actualPanel = nuevoPanel;
        add(actualPanel);

        // Revalida y repinta el JFrame para reflejar el cambio
        revalidate();
        repaint();
        return actualPanel;
    }
    public JPanel cambiarPanelEx() {
        // Remueve el panel actual (p_Reproductor) y agrega el nuevo panel
        remove(p_Actual);
        p_Actual = nuevoPanelEx;
        add(p_Actual);

        // Revalida y repinta el JFrame para reflejar el cambio
        revalidate();
        repaint();
        return p_Actual;
    }
}

