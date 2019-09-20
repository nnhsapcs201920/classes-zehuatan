import javax.swing.JFrame;

public class TargetExtensionViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(300, 300);
        frame.setTitle("A special Target");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TargetExtensionComponent component = new TargetExtensionComponent();
        frame.add(component);
        
        frame.setVisible(true);
    }
}