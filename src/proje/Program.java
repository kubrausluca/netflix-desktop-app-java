package proje;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Program {
	
	// Veritabanýndaki her programý bu class içinde tutuyoruz...
	
	private int programID;
	private String ad;
	private String tip;
	private int tur1;
	private int tur2;
	private int tur3;
	private int sezon;
	private int bolum_sayisi;
	private int sure;
	private float imdb;
	private String img;
	private String izleme_tarihi;
	private String izleme_suresi;
	private int bolum;
	private int puan;
	
	
	
	public Program(String ad, String izleme_tarihi, String izleme_suresi, int bolum, int puan, String img) {
		super();
		this.ad = ad;
		this.izleme_tarihi = izleme_tarihi;
		this.izleme_suresi = izleme_suresi;
		this.bolum = bolum;
		this.puan = puan;
		this.img = img;
	}


	public Program(String ad, int sezon, int bolum_sayisi, int sure, float imdb, String img) {
		super();
		this.ad = ad;
		this.sezon = sezon;
		this.bolum_sayisi = bolum_sayisi;
		this.sure = sure;
		this.imdb = imdb;
		this.img = img;
	}
	
	
	public Program(String ad, int tur1, int tur2, int tur3, int sezon, int bolum_sayisi, int sure, float imdb) {
		super();
		this.ad = ad;
		this.tur1 = tur1;
		this.tur2 = tur2;
		this.tur3 = tur3;
		this.sezon = sezon;
		this.bolum_sayisi = bolum_sayisi;
		this.sure = sure;
		this.imdb = imdb;
	}
	
	
	
	public Program(String ad, int sezon, int bolum_sayisi, int sure, float imdb, JLabel imageLabel) {
		super();
		this.ad = ad;
		this.sezon = sezon;
		this.bolum_sayisi = bolum_sayisi;
		this.sure = sure;
		this.imdb = imdb;
		
	}


	public int getProgramID() {
		return programID;
	}
	public void setProgramID(int programID) {
		this.programID = programID;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getTur1() {
		return tur1;
	}
	public void setTur1(int tur1) {
		this.tur1 = tur1;
	}
	public int getTur2() {
		return tur2;
	}
	public void setTur2(int tur2) {
		this.tur2 = tur2;
	}
	public int getTur3() {
		return tur3;
	}
	public void setTur3(int tur3) {
		this.tur3 = tur3;
	}
	public int getSezon() {
		return sezon;
	}
	public void setSezon(int sezon) {
		this.sezon = sezon;
	}
	public int getBolum_sayisi() {
		return bolum_sayisi;
	}
	public void setBolum_sayisi(int bolum_sayisi) {
		this.bolum_sayisi = bolum_sayisi;
	}
	public int getSure() {
		return sure;
	}
	public void setSure(int sure) {
		this.sure = sure;
	}
	public float getImdb() {
		return imdb;
	}
	public void setImdb(float imdb) {
		this.imdb = imdb;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	public String getIzleme_tarihi() {
		return izleme_tarihi;
	}


	public void setIzleme_tarihi(String izleme_tarihi) {
		this.izleme_tarihi = izleme_tarihi;
	}


	public String getIzleme_suresi() {
		return izleme_suresi;
	}


	public void setIzleme_suresi(String izleme_suresi) {
		this.izleme_suresi = izleme_suresi;
	}


	public int getBolum() {
		return bolum;
	}


	public void setBolum(int bolum) {
		this.bolum = bolum;
	}


	public int getPuan() {
		return puan;
	}


	public void setPuan(int puan) {
		this.puan = puan;
	}
	
	
	
	
	
}
