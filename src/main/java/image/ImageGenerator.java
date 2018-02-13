package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: ImageGenerator
 * Description: 给给定的图片加文字
 * <p>

 *
 * @author create 陈雷 2018/1/23
 * @version 1.0
 * @since 1.0
 */
public class ImageGenerator {

	private BufferedImage template;

	private Font font;

	private Color color;


	private Iterable<Words> words;

	private String formatName ;

	private Map<String,String> param;

	private static final Font DEFAULT_FONT = new Font("微软雅黑", Font.PLAIN, 30);
	private static final Color DEFAULT_COLOR= Color.BLACK;
	private static final String DEFAULT_FORMAT_NAME= "png";
	private ImageGenerator() {}

	public static  ImageGenerator generator(){
		return  new ImageGenerator();
	}

	public  void generate(OutputStream out) throws IOException {

		if(template == null){
			return;
		}
		Graphics2D g = this.template.createGraphics();
		g.setFont(font != null ?font :DEFAULT_FONT);
		g.setColor(color != null ? color :DEFAULT_COLOR);

		if(words != null){
			for(Words word : words){
				Font font = word.getFont();
				Font oldFont = g.getFont();
				if(font != null){
					g.setFont(font);
				}
				String content = param.get(word.getName());
				g.drawString(content == null?"":content, word.getX(),  word.getY());
				g.setFont(oldFont);
			}
		}
		g.dispose();
		// 生成新的合成过的用户二维码并写入新图片
		ImageIO.write(template, formatName ==null?DEFAULT_FORMAT_NAME :formatName , out);
	}

	/**
	 * 自定义字体
	 */
	public static Font customFont(InputStream is ,float fontSize) {
		Font definedFont = null;
		try {
			definedFont = Font.createFont(Font.TRUETYPE_FONT, is);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		//设置字体大小，float型
		definedFont = definedFont.deriveFont(fontSize);
		return  definedFont;
	}
	public static Font customFont(String fileName,float fontSize) {

		try {
			return  customFont(new FileInputStream(new File(fileName)),fontSize);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public BufferedImage getTemplate() {
		return template;
	}

	public ImageGenerator setTemplate(BufferedImage template) {
		this.template = template;
		return this;
	}
	public ImageGenerator setTemplate(String template) {

		try {
			return setTemplate(new FileInputStream(new File(template)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return this;
		}
	}
	public ImageGenerator setTemplate(InputStream in) {

		BufferedImage imageLocal = null;
		try {
			imageLocal = ImageIO.read(in);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		this.template = imageLocal;
		return this;
	}

	public Font getFont() {
		return font;
	}

	public ImageGenerator setFont(Font font) {
		this.font = font;
		return this;
	}
	public ImageGenerator setFont(String name, int style, int size) {
		this.font = new Font(name,style,size);
		return this;
	}

	public Color getColor() {
		return color;
	}

	public ImageGenerator setColor(Color color) {
		this.color = color;
		return this;
	}

	public Iterable<Words> getWords() {
		return words;
	}

	public ImageGenerator setWords(Iterable<Words> words) {
		this.words = words;
		return this;
	}

	public String getFormatName() {
		return formatName;
	}

	public ImageGenerator setFormatName(String formatName) {
		this.formatName = formatName;
		return this;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public ImageGenerator setParam(Map<String, String> param) {
		this.param = param;
		return this;
	}

	public static class Words{

		private String name;


		private int x;

		private int y;

		private Font font;



		public Words(String name, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}
		public Words(String name, int x, int y,Font font) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.font = font;
		}
		public String getName() {
			return name;
		}
		public Font getFont() {
			return font;
		}

		public void setFont(Font font) {
			this.font = font;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}


	/**
	 * demo 实例
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<Words> list = new ArrayList<Words>();
		list.add(new Words("1",1209,4039,
				ImageGenerator.customFont(ImageGenerator.class.getClassLoader().getResourceAsStream("汉仪行楷简.ttf"), 150)));
		list.add(new Words("2",2545,4295));
		list.add(new Words("3",1473,5815));
		list.add(new Words("4",2281,5815));
		list.add(new Words("5",2657,5815));
		list.add(new Words("6",3193,5815));
		list.add(new Words("7",4009,5815));
		list.add(new Words("8",4457,5815));

		Map<String,String> map = new HashMap<String, String>();
		map.put("1","李小红");
		map.put("2","2个小时");
		map.put("3","2017");
		map.put("4","02");
		map.put("5","01");
		map.put("6","2017");
		map.put("7","03");
		map.put("8","15");

		ImageGenerator.generator()
				.setTemplate("C:\\Users\\chenl\\Desktop\\volunteer.png")
				.setWords(list)
				.setFormatName("jpg")
				.setFont("微软雅黑", Font.PLAIN, 150)
				.setParam(map)
				.generate(new FileOutputStream(new File("C:\\Users\\chenl\\Desktop\\志愿者2.jpg")));

	}
}
