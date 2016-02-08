import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler {
    static long startTime;

    public Euler() {
    }
    
    
    public static void main(String[] args) throws Exception {
	System.out.println("Started: ");
	Euler e = new Euler();
	startTime = System.currentTimeMillis();
	//e.go1();
	//e.go2();
	//e.go3();
	//e.go4();
	//e.go5();
	e.go6();
//	e.go7();
//	e.go8();
//	e.go9();
//	e.go10();
//	e.go11();
//	e.go12();
//	e.go13();
	System.out.println("Completed in: " + (System.currentTimeMillis() - startTime));
    }
    
    public void go1() {
	int sum = 0;
	for (int i = 1; i < 1000; i++) {
	    if (i % 3 == 0 || i % 5 == 0) {
		sum += i;
	    }
	}
	System.out.println("result is: " + sum);
    }

    public void go2() {
	int sum = 0;
	int fib1 = 1;
	int fib2 = 2;
	while (fib2 < 4000000) {
	    if (fib2 % 2 == 0) {
		sum += fib2;
	    }
	    int fibnext = fib1 + fib2;
	    fib1 = fib2;
	    fib2 = fibnext;
	}
	System.out.println("sum is: " + sum);
    }
    
    public List<Long> factors(long i) {
	List<Long> factors = new ArrayList<Long>();
	for (long factor = 1; factor <= i; factor++) {
	    if (i % factor == 0) {
		factors.add(new Long(factor));
	    }
	}
	return factors;
    }

    public Map<Long, Integer> primeFactors(long l) {
	Map<Long, Integer> factors = new HashMap<Long, Integer>();
	long factor = 2L;
	while (l > 1) {
	    while (l % factor == 0) {
		l = l / factor;
		Long factorL = new Long(factor);
		Integer num = factors.get(factorL);
		if (num == null) {
		    factors.put(factorL, new Integer(1));
		} else {
		    factors.put(factorL, new Integer(num.intValue() + 1));
		}
	    }
	    factor++;
	}
	return factors;
    }

    public int numFactors(long l) {
	Map<Long, Integer> primefactors = primeFactors(l);
	int total = 1;
	for (Integer i : primefactors.values()) {
	    total = total * (i.intValue() + 1);
	}
	return total;
    }

    public List<Long> distinctPrimeFactors(long l) {
	List<Long> factors = new ArrayList<Long>();
	long factor = 2L;
	while (l > 1) {
	    boolean first = true;
	    while (l % factor == 0) {
		l = l / factor;
		if (first) {
		    factors.add(new Long(factor));
		    first = false;
		}
	    }
	    factor++;
	}
	return factors;
    }


    public void go3() {
	long num = 600851475143L;
	// long limit = (long) Math.sqrt((double)num);
	long factor = 2;
	while (num > 1) {
	    while (num % factor == 0) {
		num = num / factor;
		System.out.println("Got factor: " + factor);
	    }
	    factor++;
	}
    }

    boolean isPalindrome(int x) {
	String str = Integer.toString(x);
	for (int i = 0; i < str.length() / 2; i++) {
	    if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
		return false;
	    }
	}
	return true;
    }

    public void go4() {
	int max = 0;
	for (int x = 900; x < 1000; x++) {
	    for (int y = 900; y < 1000; y++) {
		int product = x * y;
		if (product > max) {
		    if (isPalindrome(product)) {
			max = product;
			System.out.println("Found palindrome: " + product);
		    }
		}
	    }
	}
    }

    public void go5() {
	int test = 20 * 19;
	while (true) {
	    boolean found = true;
	    for (int i = 2; i <= 20 && found; i++) {
		if ((test % i) != 0) {
		    found = false;
		}
	    }
	    if (found) {
		System.out.println("Lowest is: " + test);
		break;
	    }
	    test++;
	}
    }

    public void go6() {
	long total = 0;
	for (int i = 1; i <= 100; i++) {
	    for (int j = 1; j <= 100; j++) {
		if (i != j) {
		    total += i * j;
		}
	    }
	}
	System.out.println("result is: " + total);
    }

    public boolean isPrime(long l) {
	long max = (long)Math.sqrt(l);
	for (int i = 2; i <= max; i++) {
	    if (l % i == 0) {
		return false;
	    }
	}
	return true;
    }

    public void go7() {
	int count = 0;
	for (int i = 2; count < 10001; i++) {
	    if (isPrime(i)) {
		System.out.println(i);
		count++;
	    }
	}
    }

    boolean squarefree(long l) {
	long limit = (long)Math.sqrt(l);
	for (long i = 2; i <= limit; i++) {
	    if (l % (i * i) == 0) {
		return false;
	    }
	}
	return true;
    }

    int mobius(long l) {
	if (squarefree(l)) {
	    if (distinctPrimeFactors(l).size() % 2 == 0) {
		return 1;
	    } else {
		return -1;
	    }
	} else {
	    return 0;
	}
    }
    
    boolean satisfiesC(int[] list, int a, int b) {
	int positive = 0;
	int negative = 0;
	for (int i = a; i <= b; i++) {
	    if (list[i] == 1) {
		positive++;
	    } else if (list[i] == -1) {
		negative++;
	    }
	}
	System.out.println("Satisfies: " + a + ", " + b + " P: " + positive + " N:" + negative);
	if ((99 * negative <= 100 * positive) && 
	    (99 * positive <= 100 * negative)) {
	    return true;
	} else {
	    return false;
	}
    }

    int mobC(int[] list, int n) {
	int count = 0;
	for (int a = 1; a <= n; a++) {
	    for (int b = a; b <= n; b++) {
		if (satisfiesC(list, a, b)) {
		    count++;
		}
	    }
	}
	return count;
    }

    public void go464() {
	final int max = 20000000;
	int[] mobiusList = new int[max + 1];
	for (int i = 1; i <= max; i++) {
	    mobiusList[i] = mobius(i);
	    System.out.println("Done mobius: " + i);
	}
	
	System.out.println("result for " + max + " is " + mobC(mobiusList, max));
    }

    public void go8() {
	String number="7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";

	int max = 0;
	int product = 0;
	for (int i = 0; i < number.length() - 5; i++) {
	    if (product == 0) {
		product = 1;
		for (int j = 0; j < 5; j++) {
		    product *= Integer.parseInt(number.substring(i + j, i + j + 1));
		}
	    } else {
		int newnum = Integer.parseInt(number.substring(i + 4, i+5));
		if (newnum == 0) {
		    product = 0;
		    i+= 4;
		}
		int oldnum = Integer.parseInt(number.substring(i - 1, i));
		product = product * newnum / oldnum;
	    }
	    if (product > max) {
		max = product;
		System.out.println("new max is: " + max);
	    }
	}
    }

    public void go9() {
	for (int a = 1; a < 998; a++) {
	    for (int b = 1; b < (1000 - a - 1); b++) {
		int c = 1000 - (a + b);
		if (a*a + b*b == c*c) {
		    System.out.println("Got triplet: " + a + ", " + b + ", " + c + " with product: " + (a * b * c));
		}
	    }
	}
    }

    public void go10() {
	long total = 0;
	for (int i = 2; i < 2000000; i++) {
	    if (isPrime(i)) {
		total += i;
		System.out.println("Found prime: " + i);
            }
	}
	System.out.println("total is: " + total);
    }

    public void go11() {
	int[][] grid = {
	    {8, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8},
	    {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00},
	    {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65},
	    {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91},
	    {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
	    {24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
	    {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
	    {67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
	    {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
	    {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95},
	    {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92},
	    {16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57},
	    {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
	    {19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40},
	    {04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
	    {88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
	    {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
	    {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16},
	    {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54},
	    {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48}};

	int maxprod = 0;
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 20; j++) {
		int prod1 = 1;
		int prod2 = 1;
		int prod3 = 1;
		int prod4 = 1;
		for (int k = 0; k < 4; k++) {
		    if (i + k < 20) {
			prod1 *= grid[i + k][j];
		    } else {
			prod1 = -1;
		    }
		    if (j + k < 20) {
			prod2 *= grid[i][j + k];
		    } else {
			prod2 = -1;
		    }
		    if (i + k < 20 && j + k < 20) {
			prod3 *= grid[i + k][j + k];
		    } else {
			prod3 = -1;
		    }
		    if (i + k < 20 && j - k > 0) {
			prod4 *= grid[i + k][j - k];
		    } else {
			prod4 = -1;
		    }
		}
		if (prod1 > maxprod) {
		    maxprod = prod1;
		}
		if (prod2 > maxprod) {
		    maxprod = prod2;
		}
		if (prod3 > maxprod) {
		    maxprod = prod3;
		}
		if (prod4 > maxprod) {
		    maxprod = prod4;
		}

	    }
	}
	System.out.println("MAx is: " + maxprod);
    }
    
    public void go12() {
	long triangle = 1;
	long count = 2;
	int maxSoFar = 0;
	while (true) {
	    triangle += count;
	    count++;
	    int numfactors = numFactors(triangle);
	    if (numfactors > maxSoFar) {
		maxSoFar = numfactors;
		System.out.println("triangle number: " + triangle + " has factors: " + numfactors);
	    }
	    if (numfactors > 500) {
		break;
	    }
	}
    }

    public void go13() {
	String[] nums = {
	    "37107287533902102798797998220837590246510135740250",
	    "46376937677490009712648124896970078050417018260538",
	    "74324986199524741059474233309513058123726617309629",
	    "91942213363574161572522430563301811072406154908250",
	    "23067588207539346171171980310421047513778063246676",
	    "89261670696623633820136378418383684178734361726757",
	    "28112879812849979408065481931592621691275889832738",
	    "44274228917432520321923589422876796487670272189318",
	    "47451445736001306439091167216856844588711603153276",
	    "70386486105843025439939619828917593665686757934951",
	    "62176457141856560629502157223196586755079324193331",
	    "64906352462741904929101432445813822663347944758178",
	    "92575867718337217661963751590579239728245598838407",
	    "58203565325359399008402633568948830189458628227828",
	    "80181199384826282014278194139940567587151170094390",
	    "35398664372827112653829987240784473053190104293586",
	    "86515506006295864861532075273371959191420517255829",
	    "71693888707715466499115593487603532921714970056938",
	    "54370070576826684624621495650076471787294438377604",
	    "53282654108756828443191190634694037855217779295145",
	    "36123272525000296071075082563815656710885258350721",
	    "45876576172410976447339110607218265236877223636045",
	    "17423706905851860660448207621209813287860733969412",
	    "81142660418086830619328460811191061556940512689692",
	    "51934325451728388641918047049293215058642563049483",
	    "62467221648435076201727918039944693004732956340691",
	    "15732444386908125794514089057706229429197107928209",
	    "55037687525678773091862540744969844508330393682126",
	    "18336384825330154686196124348767681297534375946515",
	    "80386287592878490201521685554828717201219257766954",
	    "78182833757993103614740356856449095527097864797581",
	    "16726320100436897842553539920931837441497806860984",
	    "48403098129077791799088218795327364475675590848030",
	    "87086987551392711854517078544161852424320693150332",
	    "59959406895756536782107074926966537676326235447210",
	    "69793950679652694742597709739166693763042633987085",
	    "41052684708299085211399427365734116182760315001271",
	    "65378607361501080857009149939512557028198746004375",
	    "35829035317434717326932123578154982629742552737307",
	    "94953759765105305946966067683156574377167401875275",
	    "88902802571733229619176668713819931811048770190271",
	    "25267680276078003013678680992525463401061632866526",
	    "36270218540497705585629946580636237993140746255962",
	    "24074486908231174977792365466257246923322810917141",
	    "91430288197103288597806669760892938638285025333403",
	    "34413065578016127815921815005561868836468420090470",
	    "23053081172816430487623791969842487255036638784583",
	    "11487696932154902810424020138335124462181441773470",
	    "63783299490636259666498587618221225225512486764533",
	    "67720186971698544312419572409913959008952310058822",
	    "95548255300263520781532296796249481641953868218774",
	    "76085327132285723110424803456124867697064507995236",
	    "37774242535411291684276865538926205024910326572967",
	    "23701913275725675285653248258265463092207058596522",
	    "29798860272258331913126375147341994889534765745501",
	    "18495701454879288984856827726077713721403798879715",
	    "38298203783031473527721580348144513491373226651381",
	    "34829543829199918180278916522431027392251122869539",
	    "40957953066405232632538044100059654939159879593635",
	    "29746152185502371307642255121183693803580388584903",
	    "41698116222072977186158236678424689157993532961922",
	    "62467957194401269043877107275048102390895523597457",
	    "23189706772547915061505504953922979530901129967519",
	    "86188088225875314529584099251203829009407770775672",
	    "11306739708304724483816533873502340845647058077308",
	    "82959174767140363198008187129011875491310547126581",
	    "97623331044818386269515456334926366572897563400500",
	    "42846280183517070527831839425882145521227251250327",
	    "55121603546981200581762165212827652751691296897789",
	    "32238195734329339946437501907836945765883352399886",
	    "75506164965184775180738168837861091527357929701337",
	    "62177842752192623401942399639168044983993173312731",
	    "32924185707147349566916674687634660915035914677504",
	    "99518671430235219628894890102423325116913619626622",
	    "73267460800591547471830798392868535206946944540724",
	    "76841822524674417161514036427982273348055556214818",
	    "97142617910342598647204516893989422179826088076852",
	    "87783646182799346313767754307809363333018982642090",
	    "10848802521674670883215120185883543223812876952786",
	    "71329612474782464538636993009049310363619763878039",
	    "62184073572399794223406235393808339651327408011116",
	    "66627891981488087797941876876144230030984490851411",
	    "60661826293682836764744779239180335110989069790714",
	    "85786944089552990653640447425576083659976645795096",
	    "66024396409905389607120198219976047599490197230297",
	    "64913982680032973156037120041377903785566085089252",
	    "16730939319872750275468906903707539413042652315011",
	    "94809377245048795150954100921645863754710598436791",
	    "78639167021187492431995700641917969777599028300699",
	    "15368713711936614952811305876380278410754449733078",
	    "40789923115535562561142322423255033685442488917353",
	    "44889911501440648020369068063960672322193204149535",
	    "41503128880339536053299340368006977710650566631954",
	    "81234880673210146739058568557934581403627822703280",
	    "82616570773948327592232845941706525094512325230608",
	    "22918802058777319719839450180888072429661980811197",
	    "77158542502016545090413245809786882778948721859617",
	    "72107838435069186155435662884062257473692284509516",
	    "20849603980134001723930671666823555245252804609722",
	    "53503534226472524250874054075591789781264330331690"
	};  
	double digits = 0;
	for (int i = 0; i < 22; i++) {
	    int sum = 0;
	    for (int j = 0; j < nums.length; j++) {
		char digit = nums[j].charAt(i);
		sum += Character.getNumericValue(digit);
	    }
	    digits = digits * 10 + sum;
	}
	System.out.println("digits is: " + digits);
    }
    
    long collatz(long n) {
	if (n % 2 == 0) {
	    return n / 2;
	} else {
	    return 3 * n + 1;
	}
    }
    
    int collatzDistance(long n) {
	if (n == 1) {
	    return 1;
	} else {
	    return 1 + collatzDistance(collatz(n));
	}
    }

    public void go14() {
	int max = 0;
	for (long i = 1; i < 1000000; i++) {
	    int distance = collatzDistance(i);
	    if (distance > max) {
		max = distance;
		System.out.println("new max: " + i + " with distance: " + distance);
	    }
	}
    }

    long combinations(int n) {
	if (n == 1) {
	    return 2;
	} else {
	    return combinations(n - 1) * (2 * n) * (2 * n - 1) / (n * n);
	}
    }

    public void go15() {
	/* answer is just 40c20 ie ( 40! / (20! * 20!)) but hard to work
           that out as we exceed long so we use recursive solution */
	System.out.println("combinations : " + combinations(20));
    }

    public void go16() {
	int[] digits = new int[1000];
	for (int i = 0; i < 1000; i++) {
	    digits[i] = 0;
	}
	digits[0] = 1;

	for (int i = 0; i < 1000; i++) {
	    for (int j = 999; j >= 0; j--) {
		digits[j] = digits[j] * 2;
		if (digits[j] > 9) {
		    digits[j] = digits[j] - 10;
		    digits[j + 1]++;
		}
	    }
	}
	int sum = 0;
	for (int i = 0; i < 1000; i++) {
	    sum += digits[i];
	}

	System.out.println("sum is: " + sum);
    }

    public void go17() {
	/* from one to nineteen */
	int[] letters = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
	/* from twenty to ninety */
	int[] tensLetters = {6, 6, 5, 5, 5, 7, 6, 6};

	/* from hundred to thousand */
	int[] powersLetters = {7, 8};

	int andLetters = 3;
	int grandTotal = 0;
	for (int i = 1; i <= 1000; i++) {
	    int total = 0;
	    int thousands = i / 1000;
	    int hundreds = (i % 1000) / 100;
	    int tens = (i % 100) / 10;
	    int units = (i % 10);
	    boolean and = false;
	    if (thousands > 0) {
		total += powersLetters[1] + letters[thousands - 1];
		and = true;
	    }
	    if (hundreds > 0) {
		total += powersLetters[0] + letters[hundreds - 1];
		and = true;
	    }
	    if (and) {
		total += andLetters;
	    }
	    if (tens > 1) {
		total += tensLetters[tens - 2];
		if (units > 0) {
		    total += letters[units - 1];
		}
	    } else {
		if (units > 0 || tens > 0) {
		    total += letters[(tens * 10) + units - 1];
		} else { /* we don't need the 'and' in this case */
		    if (and) {
			total -= andLetters;
		    }
		}
	    }
	    System.out.println("for: " + i + " total: " + total);
	    grandTotal += total;
	}
	System.out.println("grandTotal is: " + grandTotal);
    }

    public int[][] readTriangle(String file, int size) throws Exception {
	int[][] result = new int[size][size];
	int count = 1;
	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line = br.readLine();
		while (line != null) {
		    String[] bits = line.split(" ");
		    for (int i = 0; i < count; i++) {
			result[count - 1][i] = Integer.parseInt(bits[i]);
			System.out.println("Got: " + result[count - 1][i]);
		    }
		    line = br.readLine();
		    count++;
		}
	    }
	return result;
    }

    public void go18() throws Exception {
	/* our triangle has 15 rows for this one */
	int[][] triangle = readTriangle("18.txt", 15);

	for (int row = 14; row > 0; row--) {
	    for (int col = 0; col < row; col++) {
		if (triangle[row][col] > triangle[row][col + 1]) {
		    triangle[row - 1][col] += triangle[row][col];
		} else {
		    triangle[row - 1][col] += triangle[row][col + 1];
		}
	    }
	}
	System.out.println("Max is: " + triangle[0][0]);
    }

    public void go19() {
	System.out.println("First guess is 1200 / 7 which gives right answer: " + (1200 / 7));
    }

    public void go20() {
	int maxdigits = 200;
	int[] digits = new int[maxdigits];
	for (int i = 0; i < maxdigits; i++) {
	    digits[i] = 0;
	}
	digits[0] = 1;
	for (int i = 2; i <= 100; i++) {
	    for (int j = maxdigits - 1; j >= 0; j--) {
		int newval = digits[j] * i;
		digits[j] = newval % 10;
		newval = newval / 10;
		int power = 1;
		while (newval > 0) {
		    digits[j + power] += newval % 10;
		    if (digits[j + power] >= 10) {
			    digits[j + power] -= 10;
			    digits[j + power + 1]++;
			}
		    newval = newval / 10;
		    power++;
		}
	    }
	    /*		System.out.println("Result for: " + i);
		for (int k = maxdigits - 1; k >= 0; k--) {
		    System.out.print(digits[k]);
		}
	    */
	}
	int total = 0;
	for (int i = maxdigits - 1; i >= 0; i--) {
	    total += digits[i];
	    System.out.print(digits[i]);
	}
	System.out.println("  Total is: " + total);
    }

    public void go67() throws Exception {
	/* our triangle has 100 rows for this one */
	int[][] triangle = readTriangle("67.txt", 100);

	for (int row = 99; row > 0; row--) {
	    for (int col = 0; col < row; col++) {
		if (triangle[row][col] > triangle[row][col + 1]) {
		    triangle[row - 1][col] += triangle[row][col];
		} else {
		    triangle[row - 1][col] += triangle[row][col + 1];
		}
	    }
	}
	System.out.println("Max is: " + triangle[0][0]);
    }

}
    

