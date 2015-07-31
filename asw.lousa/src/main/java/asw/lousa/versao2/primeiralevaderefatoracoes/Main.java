package asw.lousa.versao2.primeiralevaderefatoracoes;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	private static final class Celula extends JLabel {
		private static final long serialVersionUID = 1L;

		int linha, coluna;

		public Celula(int linha, int coluna) {
			this.linha = linha;
			this.coluna = coluna;
			setOpaque(true);
		}

	}

	static boolean botaoPressionado;

	public static void main(String[] args) throws IOException {
		final EntityManagerFactory emf = configurarAcessoBanco();

		JFrame frame = new JFrame("Lousa");
		int numeroLinhas = 4;
		int numeroColunas = 6;
		frame.setLayout(new GridLayout(numeroLinhas, numeroColunas));

		EntityManager em = emf.createEntityManager();
		for (int linha = 0; linha < numeroLinhas; ++linha) {
			for (int coluna = 0; coluna < numeroColunas; ++coluna) {
				final Celula celula = new Celula(linha, coluna);
				celula.addMouseListener(new MouseAdapter() {
					private void preencherCelula() {
						celula.setBackground(Color.BLACK);
						EntityManager em2 = emf.createEntityManager();
						em2.getTransaction().begin();
						Query q = em2.createNativeQuery("INSERT INTO CelulaPreenchida(i,j) VALUES(" + celula.linha
								+ "," + celula.coluna + ")");
						q.executeUpdate();
						em2.getTransaction().commit();
						em2.close();

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						if (botaoPressionado) {
							preencherCelula();
						}
					}
					@Override
					public void mousePressed(MouseEvent e) {
						preencherCelula();
						botaoPressionado = true;
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						botaoPressionado = false;
					}
				});
				TypedQuery<Long> q = em.createQuery("SELECT COUNT(1) FROM CelulaPreenchida WHERE i = " + linha + " AND j = " + coluna, Long.class);
				if (q.getSingleResult() == 1L) {
					celula.setBackground(Color.BLACK);
				}

				frame.add(celula);
			}
		}
		em.close();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 720);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static EntityManagerFactory configurarAcessoBanco() throws IOException {
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("javax.persistence.jdbc.url",
				"jdbc:hsqldb:file:" + File.createTempFile("lousa", ".banco").getParent()
						+ "/lousa.banco");
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb", mapa);
		return emf;
	}

}

@Entity
class CelulaPreenchida {
	@Id
	@GeneratedValue
	private Long id;

	Integer i, j;
}
