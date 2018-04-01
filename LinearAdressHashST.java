package algorithm;


import edu.princeton.cs.algs4.StdOut;

public class LinearAdressHashST<K,V> {

    private int M = 16;
    private K[] key;
    private V[] value;

    public LinearAdressHashST() {
        this.key = (K[]) new Object[M]; //难道是因为 这个泛型是我自己定义的 所以需要再自己cast?
        this.value = (V[]) new Object[M];
    }
    public LinearAdressHashST(int cap) {
        this.key = (K[]) new Object[cap]; //难道是因为 这个泛型是我自己定义的 所以需要再自己cast?
        this.value = (V[]) new Object[cap];
        this.M = cap;
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K k, V val) {
        int i;
        for (i = hash(k); key[i] != null; i = (i + 1) % M) {
            if (k.equals(key[i])) {
                value[i] = val;
                return;
            }
        }
        key[i] = k;
        value[i] = val;
    }

    public V get(K k) {
        int i;
        for (i = hash(k); key[i] != null; i = (i + 1) % M) {
            if (k.equals(key[i])) return value[i];
        }
        return null;
    }

    public boolean containis(K k) {
        for (K keys : key) if (k == keys) return true;
        return false;

    }

    public void delete(K k) {
        if (!containis(k)) return;
        int i = hash(k);
        while (!k.equals(key[i])) {
            i = (i + 1) % M;
        }
        key[i] = null;
        value[i] = null;
        i = (i + 1) % M;
        while (key[i] != null) {
            K keytemp = key[i];
            V valuetemp = value[i];
            key[i] = null;
            value[i] = null;
            put(keytemp, valuetemp);
            i = (i + 1) % M;
        }
    }


        public void resize(int cap)
        {
                LinearAdressHashST<K,V> temp = new LinearAdressHashST<>(cap);
                for(int i =0;i<key.length;i++){
                    if(key[i]!=null){
                        temp.put(key[i],value[i]);
                    }
                }
                key = temp.key;
                value = temp.value;
        }




    public static void main(String[] args){
        LinearAdressHashST st =new LinearAdressHashST();
        st.put(1,2);
        StdOut.println(st.get(1));
        StdOut.println(st.get(2));
    }

}
