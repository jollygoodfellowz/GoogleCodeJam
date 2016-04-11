import java.util.Scanner;

public class Shy {


	final public static int SMAX = 1000;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		for(int i = 1; i <= cases; i++)
		{
			int eat = sc.nextInt();
			int vals[] = new int[eat+1];

			String shy = sc.next();

			if (shy.equals("") == false)
			{
				int num_people = 0;
				int added = 0;

				for(int j = 0; j < shy.length(); j++)
				{
					vals[j] =  Character.getNumericValue(shy.charAt(j));

					if(num_people < j) 
					{
						int temp = j - num_people;
						added += temp;
						num_people += vals[j] + temp;

					}

					else
						num_people += vals[j];

				}

				System.out.println("Case #" + i + ": " + added);

				added = 0;
				num_people = 0;
			}

			else
				System.out.println("Case #" + i + ": 0");
		}

		sc.close();
		
	}

}
