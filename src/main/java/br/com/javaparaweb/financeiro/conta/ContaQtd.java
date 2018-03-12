package br.com.javaparaweb.financeiro.conta;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import br.com.javaparaweb.financeiro.util.HibernateUtil;

public class ContaQtd {
	
	private Session session;

	public ContaQtd(String string, Integer valueOf) {
	}
	public void setSession(Session session) {
		this.session = session;
	}
	@SuppressWarnings("unchecked")
	public List<ContaQtd> mostrar()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			Criteria cri = session.createCriteria(Conta.class);
			ProjectionList pr = Projections.projectionList();
			pr.add(Projections.groupProperty("funcionario"));
			pr.add(Projections.count("funcionario"));
			cri.setProjection(pr);
			List<ContaQtd> funcionarioquantidade = new ArrayList<ContaQtd>();
			List<Object[]> ligs = cri.list();
			for(Object o[]: ligs)
			{	
				funcionarioquantidade.add(new ContaQtd(o[0].toString(),Integer.valueOf(o[1].toString())));
			}
			return funcionarioquantidade;
		}finally
		{
			session.close();
		}
	}
}
