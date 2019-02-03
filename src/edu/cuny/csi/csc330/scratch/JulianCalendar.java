package edu.cuny.csi.csc330.scratch;

/**
 * Generates a non-leap year perpetual Julian Calendar 
 * @author lji
 *
 */
public class JulianCalendar {
	
	// Max number of Days in a month 
	static private  final int MAX_DAY = 31; 
	
	// abbreviated Month names 
	static private  final String [] MONTH_NAMES = {
		"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	};
	
	// day length of each month 
	static private final  int [] MONTH_SIZES = {
		31, 28, 31,30,31, 30, 31, 31, 30, 31, 30, 31
	};

	/**
	 * display The "DAY" Column Heading 
	 */
	static private final String [] THE_DAYS = {
		"001  032  060  091  121  152  182  213  244  274  305  335 ","002  033  061  092  122  153  183  214  245  275  306  336 ","003  034  062  093  123  154  184  215  246  276  307  337 ","004  035  063  094  124  155  185  216  247  277  308  338 " ,"005  036  064  095  125  156  186  217  248  278  309  339 ","006  037  065  096  126  157  187  218  249  279  310  340 ","007  038  066  097  127  158  188  219  250  280  311  341 ","008  039  067  098  128  159  189  220  251  281  312  342 ","009  040  068  099  129  160  190  221  252  282  313  343 ","010  041  069  100  130  161  191  222  253  283  314  344 ","011  042  070  101  131  162  192  223  254  284  315  345 ","012  043  071  102  132  163  193  224  255  285  316  346 ","013  044  072  103  133  164  194  225  256  286  317  347 ","014  045  073  104  134  165  195  226  257  287  318  348 ","015  046  074  105  135  166  196  227  258  288  319  349 ","016  047  075  106  136  167  197  228  259  289  320  350 ","017  048  076  107  137  168  198  229  260  290  321  351 ","018  049  077  108  138  169  199  230  261  291  322  352 ","019  050  078  109  139  170  200  231  262  292  323  353 ","020  051  079  110  140  171  201  232  263  293  324  354 ","021  052  080  111  141  172  202  233  264  294  325  355 ","022  053  081  112  142  173  203  234  265  295  326  356 ","023  054  082  113  143  174  204  235  266  296  327  357 ","024  055  083  114  144  175  205  236  267  297  328  358 ","025  056  084  115  145  176  206  237  268  298  329  359 ","026  057  085  116  146  177  207  238  269  299  330  360 ","027  058  086  117  147  178  208  239  270  300  331  361 ","028  059  087  118  148  179  209  240  271  301  332  362 ","029  000  088  119  149  180  210  241  272  302  333  363 ","030  000  089  120  150  181  211  242  273  303  334  364 ","031  000  090  000  151  000  212  243  000  304  000  365 "
	};
	static private void displayDayHeading() {
		System.out.printf("%5s", "Day");
		
	}
	
	/**
	 * display Month names between Day .... Day
	 */
	static private void displayHeading() {
		displayDayHeading(); 
		
		for(int i = 0 ; i < MONTH_NAMES.length ; ++i )  {
			System.out.printf("%5s", MONTH_NAMES[i]);
		}
		
		displayDayHeading(); 
	}
	
	static public void display() {
		displayHeading(); // display heading 
		System.out.print("\n");
		int j = 0;
		for(int i = 1; i <= 31;i++) {
			System.out.printf("%5s", i + "\t");
			System.out.printf("%5s", THE_DAYS[j]);
			System.out.printf("%5s", i);
			System.out.printf("%5s", "\n");
			j++;
		}
		/**
		 * Complete the logic to display a Julian cal given the pre-populated arrays defined by the Class
		 * 
		 * 
		 * 
		 * 
		 */

		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// invoke display method 
		display(); 
	}
}