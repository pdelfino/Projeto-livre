package br.sp.protestolivre;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class Tela05 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela05);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela05, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public void createPDF(View v){
		String nome = ((EditText)findViewById(R.id.nome)).getText().toString();
		String endereco = ((EditText)findViewById(R.id.endereco)).getText().toString();
		String cidade = ((EditText)findViewById(R.id.cidade)).getText().toString();
		String profissao = ((EditText)findViewById(R.id.profissao)).getText().toString();
		String rg = ((EditText)findViewById(R.id.rg)).getText().toString();
		String cpf = ((EditText)findViewById(R.id.cpf)).getText().toString();
		String titulo = ((EditText)findViewById(R.id.titulo)).getText().toString();
		
		int sigla = ((Spinner)findViewById(R.id.spinner1)).getSelectedItemPosition();
		String[] listEstados = {"Acre","Alagoas","Amapá","Amazonas","Bahia","Ceará","Distrito Federal","Espírito Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
		String estado = listEstados[sigla];
		
		String text1 = nome +", brasileiro, residente e domiciliado na "+endereco+", "+profissao+", portador da C.I nº "+rg+", inscrito no CPF sob o nº "+cpf+", cidadão registrado sob o título de eleitor nº "+titulo+", vem, EM CAUSA PRÓPRIA, impetrar a presente ORDEM DE HABEAS CORPUS PREVENTIVO COM PEDIDO DE LIMINAR apontando como autoridade coatora a Polícia Militar do Estado de "+ estado+", pelos fatos e fundamentos que passa a expor:";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String data = sdf.format(new Date());
		
		Font text = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL);
		Font bold = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
		String path = Environment.getExternalStorageDirectory().getPath() + "/ProtestoLivre";
		try {
			File p = new File(path);
			
			  File f = new File(p,nome.replaceAll(" ","")+data+".pdf");
			  Toast toast = Toast.makeText(getApplicationContext(), "Documento salvo em: " + f.toString(), 15);
				toast.show();
		      Document doc = new Document();
		      PdfWriter.getInstance(doc, new FileOutputStream(f));
		      doc.open();
		      doc.add(new Paragraph("EXMO. SR. JUIZ DE DIREITO DO TRIBUNAL DE JUSTIÇA DO ESTADO DE XXXXXXXXXX", text));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(text1,text));
		      doc.newPage();
		      Phrase phrase = new Phrase();
		      phrase.add(new Chunk("    O Impetrante deseja ", text));
		      phrase.add(new Chunk("exercer seus direitos fundamentais relativos à liberdade de manifestação do pensamento ", bold));
		      phrase.add(new Chunk("(art. 5º, IV, CR/88); ",text));
		      phrase.add(new Chunk("liberdade de locomoção no território nacional", bold));
		      phrase.add(new Chunk(" (art. 5º, XV, CR/88), ",text));
		      phrase.add(new Chunk("liberdade de reunião para fins pacíficos",bold));
		      phrase.add(new Chunk(" (art. 5º, XVI, CR/88), contudo, teme ter sua liberdade cerceada face aos abusos cometidos pelas forças de segurança Estadual, sobretudo sua polícia Militar, ao reprimir as manifestações ocorridas nos últimos tempos.",text));
		      Paragraph par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      doc.add(new Paragraph("Há que ser ressaltado que nos autos de cautelar inominada interposta pelo Estado de Minas Gerais contra o SINDICATO DOS SERVIDORES DA POLICIA CIVIL DO ESTADO DE "+estado+" – SINDPOL, de autos n° 0411481-04.2013.8.13.0000, foi deferida medida liminar para:",text));
		      phrase = new Phrase();
		      //phrase.add(new Chunk("",));
		     // phrase.add(new Chunk("",));
		     // phrase.add(new Chunk("",));
		      
		      doc.close();
		      
		} catch (Exception e) {
			Toast toast = Toast.makeText(getApplicationContext(),e.toString(), 10);
			toast.show(); 
		}
		
		
		
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_tela05,
					container, false);
			return rootView;
		}
	}

}
