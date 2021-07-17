int anchor=0,k=0;
        for(int i=0;i<chars.length;i++){
            if(i==chars.length-1||chars[i]!=chars[i+1]){
                chars[k++]=chars[anchor];
                if(i>anchor){
                    for(char c: (""+(i-anchor+1)).toCharArray()){
                        chars[k++]=c;
                    }
                }
                anchor=i+1;
            }
        }
        return k;
