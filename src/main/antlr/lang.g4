// OUR GRAMMAR

/*
program
   : block '.'
   ;

block
   //: consts? vars? procedure* statement
   : declaration? (PROCEDURE ident ';' block ';')* statement
   ;

declaration
    : CONST type ident ':=' value ';'
    | CONST type ident '[]' ':=' '{' value (',' value)* '}' ';'
    | VAR type ident ( '[' number ']' ) ( ',' ident ( '[' number ']' ) )* ';'
    ;
    */

// PL0
grammar lang;

program
   : block '.'
   ;

block
   : consts? vars? procedure* statement
   ;

consts
   : CONST ident '=' number (',' ident '=' number)* ';'
   ;

vars
   : VAR ident (',' ident)* ';'
   ;

procedure
   : PROCEDURE ident ';' block ';'
   ;

statement
   : (assignstmt | callstmt | writestmt | qstmt | bangstmt | beginstmt | ifstmt | whilestmt)?
   ;

assignstmt
   : ident ':=' expression
   ;

callstmt
   : CALL ident
   ;

writestmt
   : WRITE ident
   ;

qstmt
   : '?' ident
   ;

bangstmt
   : '!' expression
   ;

beginstmt
   : BEGIN statement (';' statement)* END
   ;

ifstmt
   : IF condition THEN statement
   ;

whilestmt
   : WHILE condition DO statement
   ;

condition
   : ODD expression
   | expression ('=' | '#' | '<' | '<=' | '>' | '>=') expression
   ;

expression
   : ('+' | '-')? term (('+' | '-') term)*
   ;

term
   : factor (('*' | '/') factor)*
   ;

factor
   : ident
   | number
   | '(' expression ')'
   ;

ident
   : STRING
   ;

number
   : NUMBER
   ;


WRITE
   : W R I T E
   ;


WHILE
   : W H I L E
   ;


DO
   : D O
   ;


IF
   : I F
   ;


THEN
   : T H E N
   ;


ODD
   : O D D
   ;


BEGIN
   : B E G I N
   ;


END
   : E N D
   ;


CALL
   : C A L L
   ;


CONST
   : C O N S T
   ;


VAR
   : V A R
   ;


PROCEDURE
   : P R O C E D U R E
   ;


fragment A
   : ('a' | 'A')
   ;


fragment B
   : ('b' | 'B')
   ;


fragment C
   : ('c' | 'C')
   ;


fragment D
   : ('d' | 'D')
   ;


fragment E
   : ('e' | 'E')
   ;


fragment F
   : ('f' | 'F')
   ;


fragment G
   : ('g' | 'G')
   ;


fragment H
   : ('h' | 'H')
   ;


fragment I
   : ('i' | 'I')
   ;


fragment J
   : ('j' | 'J')
   ;


fragment K
   : ('k' | 'K')
   ;


fragment L
   : ('l' | 'L')
   ;


fragment M
   : ('m' | 'M')
   ;


fragment N
   : ('n' | 'N')
   ;


fragment O
   : ('o' | 'O')
   ;


fragment P
   : ('p' | 'P')
   ;


fragment Q
   : ('q' | 'Q')
   ;


fragment R
   : ('r' | 'R')
   ;


fragment S
   : ('s' | 'S')
   ;


fragment T
   : ('t' | 'T')
   ;


fragment U
   : ('u' | 'U')
   ;


fragment V
   : ('v' | 'V')
   ;


fragment W
   : ('w' | 'W')
   ;


fragment X
   : ('x' | 'X')
   ;


fragment Y
   : ('y' | 'Y')
   ;


fragment Z
   : ('z' | 'Z')
   ;


STRING
   : [a-zA-Z] [a-zA-Z]*
   ;


NUMBER
   : [0-9] +
   ;


//WS
//   : [ \t\r\n] -> skip
//   ;