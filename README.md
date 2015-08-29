# jawjaw_cli
cli for jawjaw http://www.cs.cmu.edu/~hideki/software/jawjaw/index.html

## build

> mvn package

## usage

> com.masakir.nlp.JawJawCli -options
 -w | --word [word]
  検索するwordを指定
 -p | --pos [pos]
  a:形容詞, n:名詞, r:副詞 v:動詞 で品詞を指定

## example

> ./jawjaw_cli.sh -w 買い物 -p n
hypernyms of 買い物 : 	[買い物, 求, 買い込み, 買い, 買込み, 購入, 換物, 買い取り, 買いこみ, 買こみ, 買, 買込, 買物, 買い上げ, 買収, 買いあげ, 買上, 購買, 購求, 買いつけ, 買上げ, 買とり, 買いとり, 買取]
hyponyms of 買い物 : 	[買物, 買い物, ショッピング, 買い出し, ショッピッング]
買い物 entails : 		[]
translations of 買い物 : 	[shopping, buying, purchasing]
definitions of 買い物 : 	[searching for or buying goods or services; "went shopping for a reliable plumber"; "does her shopping at the mall rather than down town", the act of buying; "buying and selling fill their days"; "shrewd purchasing requires considerable knowledge"]



