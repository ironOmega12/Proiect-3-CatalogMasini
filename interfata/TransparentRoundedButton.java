package interfata;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TransparentRoundedButton extends JButton {
    private boolean isHovered = false;

    public TransparentRoundedButton(String text) {
        super(text);
        setOpaque(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(1.0f, 1.0f, 1.0f, isHovered ? 1.0f : 0.75f));
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2d.setColor(getForeground());
        g2d.drawString(getText(), getWidth() / 2 - getFontMetrics(getFont()).stringWidth(getText()) / 2,
                getHeight() / 2 + getFontMetrics(getFont()).getAscent() / 2);
        g2d.dispose();
    }

}
