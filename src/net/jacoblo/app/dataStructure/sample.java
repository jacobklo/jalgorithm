package net.jacoblo.app.dataStructure;

public class sample {
  
  public static void main(String[] args) {
    int[][] track = new int[3][3];
    track[0][0] = 2; track[0][1] = 2; track[0][2] = 3;
    track[1][0] = 3; track[1][1] = 1; track[1][2] = 4;
    track[2][0] = 4; track[2][1] = 4; track[2][2] = 4;
    
    System.out.println(gridlandMetro(4,4,3,track));
  }
  static int gridlandMetro(int n, int m, int k, int[][] track) {
    if ( n < 0 || m < 0 ) return 0;
    
    int[][] trainMap = convertTrackMap(n,m,track);
    
    int result = 0;
    for ( int i = 0 ; i < trainMap.length ; i++ ) {
        for ( int j = 0 ; j < trainMap[i].length ; j++ ) {
            if ( trainMap[i][j] == 0) {
                result++;
            }
        }
    }
    
    return result;

}
  
  static int[][] convertTrackMap(int n, int m, int[][] track) {
   
    int[][] trainMap = new int[n][m];
    
    for ( int i = 0 ; i < track.length ; i++ ) {
        for ( int j = track[i][1] ; j <= track[i][2] ; j++ ) {
            trainMap[track[i][0]-1][j-1] = 1;
        }
    }
    
    return trainMap;
}
  
  
}
