package asw.lousa.versao1.semestrutura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CelulaPreenchida {
	@Id
	@GeneratedValue
	private Long id;

	Integer i, j;
}

