import java.util.ArrayList;
import java.util.Random;

class ShapeLocation {
		private static final int LARGE = 240;
		private  int X_COORDINATE;
		private  int Y_COORDINATE;
		private static final int VERY_SMALL = 60;
		private ArrayList<RandomPosition> randomPositions = new ArrayList<>();

		ShapeLocation(int xCoordinate,int yCoordinate){
			X_COORDINATE = xCoordinate;
			Y_COORDINATE = yCoordinate;
		}
		int getTriangleHeight() {
			int height = ((int)(Math.round(Math.sqrt(Math.pow(VERY_SMALL,2)-Math.pow((VERY_SMALL/2),2)))));
			return height;
		}
		String getRandomFigure(){
			int random = generateRandom(1,3,-1);
			switch (random){
				case 1:
					return  "TR";
				case 2:
					return "SQ";
				default:
					return "CI";
			}
		}
		private String getRandomXStringForInt(int randomX){
			String randomXString;
			switch (randomX) {
				case 1: {
					randomXString = "L";
				}
				break;
				case 2: {
					randomXString = "R";
				}
				break;
				default: {
					randomXString = "C";
				}
			}
			return  randomXString;
		}
		private String getRandomYStringForInt(int randomY){
			String randomYString;
			switch (randomY) {
				case 1: {
					randomYString = "T";
				}
				break;
				case 2: {
					randomYString = "B";
				}
				break;
				default: {
					randomYString = "C";
				}
			}
			return randomYString;
		}
		private int generateRandom(int minLimit,int maxLimit,int excludeValue) {

			int range = maxLimit-minLimit+1;
			int randomNumber = (int)(Math.random() * range) + minLimit;
			if(excludeValue == -1) {
				return randomNumber;
			}
			else if(excludeValue <maxLimit) {
				randomNumber++;
				return  randomNumber;
			}
			else {
				randomNumber--;
				return  randomNumber;
			}

		}
		RandomPosition getRandomPositions() {
			RandomPosition randomPosition;
			while (true) {
				int randomXInt = generateRandom(1,3,-1);
				int randomYInt = generateRandom(1,3,-1);
				int previousXInt = -1;
				int previousYInt = -1;
				String randomXString = getRandomXStringForInt(randomXInt) ;
				String randomYString = getRandomYStringForInt(randomYInt);

				if(!searchForImageOverride(randomXString,randomYString)) {
					if(checkLimitForX(randomXString) && checkLimitForY(randomYString)){
						randomPosition = new RandomPosition(randomXString,randomYString);
						randomPositions.add(randomPosition);
						return  randomPosition;
					}
					else {
						if(checkLimitForX(randomXString)){

							if(randomXInt == 1){
								if(previousXInt == 2){
									previousXInt =3;
									randomXInt =3;
									randomXString = getRandomXStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
								else {
									previousXInt = 1;
									randomXInt++;
									randomXString = getRandomXStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}


							}
							else if(randomXInt == 2){
								if(previousXInt == 1){
									previousXInt =3;
									randomXInt =3;
									randomXString = getRandomXStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
								else {
									previousXInt = 2;
									randomXInt--;
									randomXString = getRandomXStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}

							}
							else {
								if(previousXInt == 2){
									previousXInt =1;
									randomXInt =1;
									randomXString = getRandomXStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
								else {
									previousXInt = 2;
									randomXInt--;
									randomXString = getRandomXStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
							}
						}
						else {
							if(randomYInt == 1){
								if(previousYInt == 2){
									previousYInt =3;
									randomYInt =3;
									randomYString = getRandomYStringForInt(randomYInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
								else {
									previousYInt = 1;
									randomYInt++;
									randomYString = getRandomYStringForInt(randomYInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}


							}
							else if(randomYInt == 2){
								if(previousYInt == 1){
									previousYInt =3;
									randomYInt =3;
									randomYString = getRandomYStringForInt(randomYInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
								else {
									previousYInt = 2;
									randomYInt--;
									randomYString = getRandomXStringForInt(randomYInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}

							}
							else {
								if(previousYInt == 2){
									previousYInt = 1;
									randomYInt =1;
									randomYString = getRandomYStringForInt(randomYInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
								else {
									previousYInt = 2;
									randomYInt--;
									randomYString = getRandomYStringForInt(randomXInt);
									if(!searchForImageOverride(randomXString,randomYString)){
										randomPosition = new RandomPosition(randomXString,randomYString);
										randomPositions.add(randomPosition);
										return  randomPosition;
									}
								}
							}

						}
					}

				}

			}
		}
		private boolean checkLimitForX(String randomXString){
		int count = 0;
		for(RandomPosition rp : randomPositions){
			if(rp.getHorizontalPosition().equalsIgnoreCase(randomXString)){
				count++;
			}
		}
		return count < 3;
	}
	private boolean checkLimitForY(String randomYString){
		int count = 0;
		for(RandomPosition rp : randomPositions){
			if(rp.getVerticalPosition().equalsIgnoreCase(randomYString)){
				count++;
			}
		}
		return count < 3;
	}

	private String generateRandomXForLimit(){
		int random;
		String randomXString;
		random = generateRandom(1,3,-1);
		while(true){
			int count = 0;
			switch (random) {
				case 1: {
					randomXString = "L";
				}
				break;
				case 2: {
					randomXString = "R";
				}
				break;
				default: {
					randomXString = "C";
				}
			}
			for(RandomPosition rp : randomPositions){
				if(rp.getVerticalPosition().equalsIgnoreCase(randomXString)){
					count++;
				}
				if(count <3){
					return randomXString;
				}
				else {
					if(random <3){
						random++;
					}
					else {
						random--;
					}
				}

			}
		}

	}

	private String generateRandomYForLimit(){
		int random;
		String randomYString;
		random = generateRandom(1,3,-1);
		while(true){
			int count = 0;
			switch (random) {
				case 1: {
					randomYString = "T";
				}
				break;
				case 2: {
					randomYString = "B";
				}
				break;
				default: {
					randomYString = "C";
				}
			}
			for(RandomPosition rp : randomPositions){
				if(rp.getVerticalPosition().equalsIgnoreCase(randomYString)){
					count++;
				}
				if(count <3){
					return randomYString;
				}
				else {
					if(random <3){
						random++;
					}
					else {
						random--;
					}
				}

			}
		}

	}
		private boolean searchForImageOverride(String randomXPosition, String randomYPosition) {
			boolean override = false;
			if (randomPositions.size() > 0) {
				for (RandomPosition rp : randomPositions) {
					if (rp.getHorizontalPosition().equalsIgnoreCase(randomXPosition) && rp.getVerticalPosition().equalsIgnoreCase(randomYPosition)) {
						override = true;
						break;
					}
				}
			}

			return override;
		}
	  int findStartingYPosition(String verticalPosition, String shape) {
		  int yCoordinate;
		  
		   if(shape.equalsIgnoreCase("Triangle")|| shape.equalsIgnoreCase("TR")) {
			  	int triangleHeight = getTriangleHeight(); 
			  if(verticalPosition.equalsIgnoreCase("Top") || verticalPosition.equalsIgnoreCase("T")){
				   yCoordinate = Y_COORDINATE+(((LARGE/3)-triangleHeight)/2)+triangleHeight; 
				  }
			  else if(verticalPosition.equalsIgnoreCase("Bottom") || verticalPosition.equalsIgnoreCase("B")){
				   yCoordinate = Y_COORDINATE+((LARGE/3)*2)+(((LARGE/3)-triangleHeight)/2)+triangleHeight; 
				  }
			  else if(verticalPosition.equalsIgnoreCase("Center") || verticalPosition.equalsIgnoreCase("C")){
				  yCoordinate = Y_COORDINATE+(LARGE/3)+(((LARGE/3)-triangleHeight)/2)+triangleHeight;
			  }
			  else {
			  	int randomNumber = generateRandom(1,3,-1);

			  	switch (randomNumber){
					case 1:
					{
						yCoordinate = Y_COORDINATE+(((LARGE/3)-triangleHeight)/2)+triangleHeight;
					}
					break;
					case 2: {
						yCoordinate = Y_COORDINATE+((LARGE/3)*2)+(((LARGE/3)-triangleHeight)/2)+triangleHeight;
					}
					break;
					default:
					{
						yCoordinate = Y_COORDINATE+(LARGE/3)+(((LARGE/3)-triangleHeight)/2)+triangleHeight;
					}
				}
			  }
		  }
		  else {
			  if(verticalPosition.equalsIgnoreCase("Top") || verticalPosition.equalsIgnoreCase("T")){
				   yCoordinate = Y_COORDINATE+10; 
				  }
			  else if(verticalPosition.equalsIgnoreCase("Bottom") || verticalPosition.equalsIgnoreCase("B")){
				   yCoordinate = Y_COORDINATE+((LARGE/3)*2)+10; 
				  }
			  else if(verticalPosition.equalsIgnoreCase("Center") || verticalPosition.equalsIgnoreCase("C")){
				  yCoordinate = Y_COORDINATE+(LARGE/3)+10;
			  }
			  else {
			  	int randomNumber = generateRandom(1,3,-1);
				  switch (randomNumber){
					  case 1:
					  {
						  yCoordinate = Y_COORDINATE+10;
					  }
					  break;
					  case 2: {
						  yCoordinate = Y_COORDINATE+((LARGE/3)*2)+10;
					  }
					  break;
					  default:
					  {
						  yCoordinate = Y_COORDINATE+(LARGE/3)+10;
					  }
				  }

			  }
		  }
		  
		  return yCoordinate;
	  }
	  
	  int findStartingXPosition(String horizontalPosition, String shape) {
		  int xCoordinate;
		  
		   if(shape.equalsIgnoreCase("Triangle")|| shape.equalsIgnoreCase("TR")) {
			  if(horizontalPosition.equalsIgnoreCase("Left") || horizontalPosition.equalsIgnoreCase("L")){
				  xCoordinate = X_COORDINATE+10; 
				  }
			  else if(horizontalPosition.equalsIgnoreCase("Right") || horizontalPosition.equalsIgnoreCase("R")){
				  xCoordinate = X_COORDINATE+((LARGE/3)*2)+10; 
				  }
			  else if(horizontalPosition.equalsIgnoreCase("Center") || horizontalPosition.equalsIgnoreCase("C")) {
				  xCoordinate = X_COORDINATE+(LARGE/3)+10;
			  }
			  else {
				  int randomNumber = generateRandom(1,3,-1);
				  switch (randomNumber){
					  case 1:
					  {
						  xCoordinate = X_COORDINATE+10;
					  }
					  break;
					  case 2: {
						  xCoordinate = X_COORDINATE+((LARGE/3)*2)+10;
					  }
					  break;
					  default:
					  {
						  xCoordinate = X_COORDINATE+(LARGE/3)+10;
					  }
				  }
			  }
		  }
		  else {
			  if(horizontalPosition.equalsIgnoreCase("LEFT") || horizontalPosition.equalsIgnoreCase("L")){
				  xCoordinate = X_COORDINATE+10; 
				  }
			  else if(horizontalPosition.equalsIgnoreCase("RIGHT") || horizontalPosition.equalsIgnoreCase("R")){
				  xCoordinate = X_COORDINATE+((LARGE/3)*2)+10; 
				  }
			  else if(horizontalPosition.equalsIgnoreCase("Center") || horizontalPosition.equalsIgnoreCase("C")){
				  xCoordinate = X_COORDINATE+(LARGE/3)+10;
			  }
			  else {
				  int randomNumber = generateRandom(1,3,-1);
				  switch (randomNumber){
					  case 1:
					  {
						  xCoordinate = X_COORDINATE+10;
					  }
					  break;
					  case 2: {
						  xCoordinate = X_COORDINATE+((LARGE/3)*2)+10;
					  }
					  break;
					  default:
					  {
						  xCoordinate = X_COORDINATE+(LARGE/3)+10;
					  }
				  }
			  }
		  }
		  
		  return xCoordinate;
	  }
	  
	  
	  
}
