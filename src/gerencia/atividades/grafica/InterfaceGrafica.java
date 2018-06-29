package gerencia.atividades.grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import gerencia.atividades.dominio.Main;
import gerencia.atividades.utilitarios.Arquivos;

public class InterfaceGrafica {
	public static final String NL = System.getProperty("line.separator"); 
	private static String defaultLocation = "";
	private JFrame janela;
	private JPanel painelPrincipal;
	private JPanel painelDocentes;
	private JPanel painelDiscentes;
	private JPanel painelProducaoCientifica;
	private JPanel painelCursos;
	private JPanel painelDidaticoAulas;
	private JPanel painelOrientacaoGraduacao;
	private JPanel painelOrientacaoPos;
	private JPanel painelTitle;
	
	String nomepadrao = "Nenhum arquivo selecionado";
	JLabel arquivoNomeDocentes = new JLabel(nomepadrao);
	JLabel arquivoNomeDiscentes = new JLabel(nomepadrao);
	JLabel arquivoNomeProducoesCientificas = new JLabel(nomepadrao);
	JLabel arquivoNomeCursos = new JLabel(nomepadrao);
	JLabel arquivoNomeAulas = new JLabel(nomepadrao);
	JLabel arquivoNomeOrientacaoGraduacao = new JLabel(nomepadrao);
	JLabel arquivoNomeOrientacaoPos = new JLabel(nomepadrao);
	
	private int selectIsSetCount = 0;
	
	//Após selecionar um arquivo, o caminho da pasta dele será setado como padrão, para facilitar na abertura dos outros arquivos.
	public static void setDefaultLocation(String file) {
		defaultLocation = "";
		String[] defaultLocationArr = file.split("/");
		for(int i = 0; i < defaultLocationArr.length - 1; i++) {
			defaultLocation = defaultLocation.concat(defaultLocationArr[i]);
			defaultLocation = defaultLocation.concat("/");
		}
	}
	
	public InterfaceGrafica(Arquivos arquivos) {
		montaTela(arquivos);
	}	
	
	private void montaTela(Arquivos arquivos) {
		  preparaJanela();
		  preparaPainelPrincipal();
		  preparaBotaoCarregar(arquivos);
		  mostraJanela();
		  preparaBotaoGerar(arquivos);
	   }


	private void preparaJanela() {
		janela = new JFrame("Gerenciamento de Docentes");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void preparaPainelPrincipal() {
		
		GridLayout gridPrincipal = new GridLayout(0,1, 10 ,10);
		GridLayout gridPainel = new GridLayout(1, 3, 10, 20);
		Border panelBorder = BorderFactory.createEmptyBorder(20,20,20,20);
		
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(gridPrincipal);
		painelPrincipal.setBorder(panelBorder);
		setPainelPrincipalStyle(painelPrincipal);
		
		painelDocentes = new JPanel();
		painelDocentes.setLayout(gridPainel);
		setPainelStyle(painelDocentes);
		
		painelDiscentes = new JPanel();
		painelDiscentes.setLayout(gridPainel);
		setPainelStyle(painelDiscentes);
		
		painelProducaoCientifica = new JPanel();
		painelProducaoCientifica.setLayout(gridPainel);
		setPainelStyle(painelProducaoCientifica);
		
		painelCursos = new JPanel();
		painelCursos.setLayout(gridPainel);
		setPainelStyle(painelCursos);
		
		painelDidaticoAulas = new JPanel();
		painelDidaticoAulas.setLayout(gridPainel);
		setPainelStyle(painelDidaticoAulas);
		
		painelOrientacaoGraduacao = new JPanel();
		painelOrientacaoGraduacao.setLayout(gridPainel);
		setPainelStyle(painelOrientacaoGraduacao);
		
		painelOrientacaoPos = new JPanel();
		painelOrientacaoPos.setLayout(gridPainel);
		setPainelStyle(painelOrientacaoPos);
		
		
		JLabel title = new JLabel("Gerenciamento de Atividades Docentes");
		title.setFont(new Font("Monospace", Font.PLAIN, 24));
		painelTitle = new JPanel();
		painelTitle.setLayout(new GridBagLayout());
		painelTitle.setBackground(new Color(255,255,255,0));
		painelTitle.add(title);
		
		
		
		painelPrincipal.add(painelTitle);
		painelPrincipal.add(painelDocentes);
		painelPrincipal.add(painelDiscentes);
		painelPrincipal.add(painelProducaoCientifica);
		painelPrincipal.add(painelCursos);
		painelPrincipal.add(painelDidaticoAulas);
		painelPrincipal.add(painelOrientacaoGraduacao);
		painelPrincipal.add(painelOrientacaoPos);
		janela.add(painelPrincipal);
	}
	
	private void preparaBotaoCarregar(Arquivos arquivos) {
		
		Border paddingLabel = BorderFactory.createEmptyBorder(10,10,10,10);
		
		
		JLabel labelDocentes = new JLabel("<html> <b> Arquivo de Docentes </b> </html>");
		labelDocentes.setBorder(paddingLabel);
		JButton botaoDocentes = new JButton("Selecionar arquivo");
		botaoDocentes.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	JFileChooser arquivoDocentes = new JFileChooser(defaultLocation);
				arquivoDocentes.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
				int retorno = arquivoDocentes.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoDocentes.getSelectedFile().exists()) {
					arquivos.setDocentes(arquivoDocentes.getSelectedFile());
					String caminho = arquivoDocentes.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeDocentes.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");
					setPainelStyle(painelDocentes);
					painelDocentes.repaint();
					setDefaultLocation(caminho);
					selectIsSetCount++;
				} else {}
				
		  }
		});
		
		JLabel labelDiscentes = new JLabel("<html> <b> Arquivo de Discentes </b> </html>");
		labelDiscentes.setBorder(paddingLabel);
		JButton botaoDiscentes = new JButton("Selecionar arquivo");
		botaoDiscentes.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  JFileChooser arquivoDiscentes = new JFileChooser(defaultLocation);
				arquivoDiscentes.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
				int retorno = arquivoDiscentes.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoDiscentes.getSelectedFile().exists()) {
					arquivos.setDiscentes(arquivoDiscentes.getSelectedFile());
					String caminho = arquivoDiscentes.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeDiscentes.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");setDefaultLocation(caminho);
					selectIsSetCount++;
				} else {}
		  }
		});
		
		JLabel labelProducaoCientifica = new JLabel("<html> <b> Arquivo de Producao Cientifica </b> </html>");
		labelProducaoCientifica.setBorder(paddingLabel);
		JButton botaoProducaoCientifica = new JButton("Selecionar arquivo");
		botaoProducaoCientifica.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	JFileChooser arquivoProducaoCientifica = new JFileChooser(defaultLocation);
				arquivoProducaoCientifica.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
				int retorno = arquivoProducaoCientifica.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoProducaoCientifica.getSelectedFile().exists()) {
					arquivos.setProducaoCientifica(arquivoProducaoCientifica.getSelectedFile());
					String caminho = arquivoProducaoCientifica.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeProducoesCientificas.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");
					setDefaultLocation(caminho);
					selectIsSetCount++;
				} else {}
		  }
		});
		
		JLabel labelCursos = new JLabel("<html> <b> Arquivo de Cursos </b> </html>");
		labelCursos.setBorder(paddingLabel);
		JButton botaoCursos = new JButton("Selecionar arquivo");
		botaoCursos.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  JFileChooser arquivoCursos = new JFileChooser(defaultLocation);
				arquivoCursos.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
				int retorno = arquivoCursos.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoCursos.getSelectedFile().exists()) {
					arquivos.setCursos(arquivoCursos.getSelectedFile());
					String caminho = arquivoCursos.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeCursos.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");
					setDefaultLocation(caminho);
					selectIsSetCount++;

				} else {}
		  }
		});
		
		JLabel labelDidaticoAulas = new JLabel("<html> <b> Arquivo de Aulas </b> </html>");
		labelDidaticoAulas.setBorder(paddingLabel);
		JButton botaoDidaticoAulas = new JButton("Selecionar arquivo");
		botaoDidaticoAulas.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	JFileChooser arquivoDidaticoAulas = new JFileChooser(defaultLocation);
				arquivoDidaticoAulas.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
				int retorno = arquivoDidaticoAulas.showOpenDialog(null);	
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoDidaticoAulas.getSelectedFile().exists()) {
					arquivos.setDidaticoAulas(arquivoDidaticoAulas.getSelectedFile());
					String caminho = arquivoDidaticoAulas.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeAulas.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");
					setDefaultLocation(caminho);
					selectIsSetCount++;

				} else {}
		  }
		});
		
		JLabel labelOrientacaoGraduacao = new JLabel("<html> <b> Arquivo de Orientacao Graduacao </b>");
		labelOrientacaoGraduacao.setBorder(paddingLabel);
		JButton botaoOrientacaoGraduacao = new JButton("Selecionar arquivo");
		botaoOrientacaoGraduacao.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	JFileChooser arquivoOrientacaoGraduacao = new JFileChooser(defaultLocation);
				arquivoOrientacaoGraduacao.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
				int retorno = arquivoOrientacaoGraduacao.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoOrientacaoGraduacao.getSelectedFile().exists()) {
					arquivos.setOrientacaoGraducao(arquivoOrientacaoGraduacao.getSelectedFile());
					String caminho = arquivoOrientacaoGraduacao.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeOrientacaoGraduacao.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");
					setDefaultLocation(caminho);
					selectIsSetCount++;

				} else {}
		  }
		});
		
		JLabel labelOrientacaoPos = new JLabel("<html> <b> Arquivo de Orientacao Pós </b>");
		labelOrientacaoPos.setBorder(paddingLabel);
		JButton botaoOrientacaoPos = new JButton("Selecionar arquivo");
		botaoOrientacaoPos.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	JFileChooser arquivoOrientacaoPos = new JFileChooser(defaultLocation);
			  	arquivoOrientacaoPos.setFileFilter(new FileNameExtensionFilter("Somente CSV", "csv"));
			  	int retorno = arquivoOrientacaoPos.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION && arquivoOrientacaoPos.getSelectedFile().exists()) {
					arquivos.setOrientacaoPos(arquivoOrientacaoPos.getSelectedFile());
					String caminho = arquivoOrientacaoPos.getSelectedFile().toString();
					String[] caminhoArr = caminho.split("/");
					arquivoNomeOrientacaoPos.setText("<html><font color='red'>" +(caminhoArr[caminhoArr.length-1])+ "</font></html>");
					setDefaultLocation(caminho);
					selectIsSetCount++;

				} else {}
		  }
		});
		
//		labelDocentes.setHorizontalTextPosition(JLabel.CENTER);
//		labelDiscentes.setHorizontalTextPosition(JLabel.CENTER);
//		labelProducaoCientifica.setHorizontalTextPosition(JLabel.CENTER);
//		labelCursos.setHorizontalTextPosition(JLabel.CENTER);
//		labelDidaticoAulas.setHorizontalTextPosition(JLabel.CENTER);
//		labelOrientacaoGraduacao.setHorizontalTextPosition(JLabel.CENTER);
//		labelOrientacaoPos.setHorizontalTextPosition(JLabel.CENTER);
//		
//		botaoDocentes.setHorizontalTextPosition(JLabel.RIGHT);
//		botaoDiscentes.setHorizontalTextPosition(JLabel.RIGHT);
//		botaoProducaoCientifica.setHorizontalTextPosition(JLabel.RIGHT);
//		botaoCursos.setHorizontalTextPosition(JLabel.RIGHT);
//		botaoDidaticoAulas.setHorizontalTextPosition(JLabel.RIGHT);
//		botaoOrientacaoGraduacao.setHorizontalTextPosition(JLabel.RIGHT);
//		botaoOrientacaoPos.setHorizontalTextPosition(JLabel.RIGHT);
		
		setButtonStyle(botaoDocentes);
		setButtonStyle(botaoDiscentes);
		setButtonStyle(botaoProducaoCientifica);
		setButtonStyle(botaoCursos);
		setButtonStyle(botaoDidaticoAulas);
		setButtonStyle(botaoOrientacaoGraduacao);
		setButtonStyle(botaoOrientacaoPos);
		
		
		
		painelDocentes.add(labelDocentes);
		painelDocentes.add(arquivoNomeDocentes);
		painelDocentes.add(botaoDocentes);
		
		
		painelDiscentes.add(labelDiscentes);
		painelDiscentes.add(arquivoNomeDiscentes);
		painelDiscentes.add(botaoDiscentes);
		
		
		painelProducaoCientifica.add(labelProducaoCientifica);
		painelProducaoCientifica.add(arquivoNomeProducoesCientificas);
		painelProducaoCientifica.add(botaoProducaoCientifica);
		
		painelCursos.add(labelCursos);
		painelCursos.add(arquivoNomeCursos);
		painelCursos.add(botaoCursos);
		
		painelDidaticoAulas.add(labelDidaticoAulas);
		painelDidaticoAulas.add(arquivoNomeAulas);
		painelDidaticoAulas.add(botaoDidaticoAulas);
		
		
		painelOrientacaoGraduacao.add(labelOrientacaoGraduacao);
		painelOrientacaoGraduacao.add(arquivoNomeOrientacaoGraduacao);
		painelOrientacaoGraduacao.add(botaoOrientacaoGraduacao);
		
		painelOrientacaoPos.add(labelOrientacaoPos);
		painelOrientacaoPos.add(arquivoNomeOrientacaoPos);
		painelOrientacaoPos.add(botaoOrientacaoPos);
		
	}
	
	private void preparaBotaoGerar(Arquivos arquivos) {
		JButton botaoGerarRelatorios = new JButton("Gerar Relatórios");
		botaoGerarRelatorios.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	if(selectIsSetCount < 7) {
			  		JOptionPane.showMessageDialog(janela, "Você não selecionou todos os arquivos necessários", "Erro", JOptionPane.ERROR_MESSAGE );
			  	}
			  	else {
			  		JFileChooser saida = new JFileChooser();
			  		saida.setCurrentDirectory(new java.io.File("."));
			  		saida.setDialogTitle("Selecione a pasta de Saída");
			  		saida.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			  		saida.setAcceptAllFileFilterUsed(false);
			  		
				  	int retorno = saida.showOpenDialog(null);
					if (retorno == JFileChooser.APPROVE_OPTION && saida.getSelectedFile().exists()) {
						String caminho = saida.getSelectedFile().toString();
						caminho = caminho.concat("/");
						arquivos.setOutputPath(caminho);
					  	if(Main.RodaPrograma(arquivos) == 1) {
					  		Object[] options = {"Sim!",
			                "Não, sair!"};
					  		int n = JOptionPane.showOptionDialog(janela,
					  				"Arquivos gerados com sucesso em: " + caminho + NL + "Gostaria de gerar outro relatório?",
					  				"Relatório gerado com sucesso",
					  				JOptionPane.YES_NO_OPTION,
					  				JOptionPane.QUESTION_MESSAGE,
					  				null,     //do not use a custom Icon
					  				options,  //the titles of buttons
					  				options[0]); //default button title
					  		if(n == JOptionPane.YES_OPTION) {
					  			arquivoNomeDocentes.setText(nomepadrao);
					  			arquivoNomeDiscentes.setText(nomepadrao);
					  			arquivoNomeProducoesCientificas.setText(nomepadrao);
					  			arquivoNomeCursos.setText(nomepadrao);
					  			arquivoNomeAulas.setText(nomepadrao);
					  			arquivoNomeOrientacaoGraduacao.setText(nomepadrao);
					  			arquivoNomeOrientacaoPos.setText(nomepadrao);
					  			selectIsSetCount = 0;
					  			
					  			
					  			
					  		}
					  		else {
					  			System.exit(0);
					  		}
					  	}
						selectIsSetCount++;

					} else {
						JOptionPane.showMessageDialog(janela, "Local Invalido!", "Erro", JOptionPane.WARNING_MESSAGE);
					}
			  		
			  		
			  		
			  		
			  	}
			  	
		  }
		});
		painelPrincipal.add(botaoGerarRelatorios);
	}

	private void mostraJanela() {
		
	    janela.setSize(800, 511);
	    janela.setMinimumSize(new Dimension(700, 450));
	    janela.pack();
//	    janela.setResizable(false);
	    janela.setVisible(true);
	}
	
	private void setButtonStyle(JButton button) {
		//button.setBackground(Color.BLACK);
	   // button.setForeground(Color.GRAY);
	}
	
	private void setPainelPrincipalStyle(JPanel panel) {
		panel.setBackground(new Color(100,100,100,100));
	}
	
	private void setPainelStyle(JPanel panel) {
		panel.setBackground(new Color(255,255,255,200));
	}
	
}
