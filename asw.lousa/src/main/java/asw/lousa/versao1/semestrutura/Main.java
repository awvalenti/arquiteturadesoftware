package asw.lousa.versao1.semestrutura;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	private static final class JLabelExtension extends JLabel {
		private static final long serialVersionUID = 1L;

		int i, j;
	}

	static boolean b;

	public static void main(String[] args) throws IOException {
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("javax.persistence.jdbc.url",
				"jdbc:hsqldb:file:" + File.createTempFile("lousa", ".banco").getParent()
						+ "/lousa.banco");
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb", mapa);

		JFrame frame = new JFrame("Lousa");
		frame.setLayout(new GridLayout(40, 40));

		EntityManager em = emf.createEntityManager();
		for (int i = 0; i < 40; ++i) {
			for (int j = 0; j < 40; ++j) {
				final JLabelExtension painel = new JLabelExtension();
				painel.i = i;
				painel.j = j;
				painel.setOpaque(true);
				painel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if (b) {
							painel.setBackground(Color.BLACK);
							EntityManager em2 = emf.createEntityManager();
							em2.getTransaction().begin();
							Query q = em2.createNativeQuery("INSERT INTO CelulaPreenchida(i,j) VALUES(" + painel.i
									+ "," + painel.j + ")");
							q.executeUpdate();
							em2.getTransaction().commit();
							em2.close();
						}
					}
					@Override
					public void mousePressed(MouseEvent e) {
						painel.setBackground(Color.BLACK);
						b = true;
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						b = false;
					}
				});
				TypedQuery<Long> q = em.createQuery("SELECT COUNT(1) FROM CelulaPreenchida WHERE i = " + i + " AND j = " + j, Long.class);
				if (q.getSingleResult() == 1L) {
					painel.setBackground(Color.BLACK);
				}

				frame.add(painel);
			}
		}
		em.close();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 720);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
