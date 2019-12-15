grammar Lang;

program
   : block '.'
   ;

block
   : (declaration)* (PROCEDURE IDENT ';' block ';')* statement
   ;

declaration
    : (consts | constarrays | vars)
    ;

consts
   : CONST TYPE IDENT ':=' VALUE ';'
   ;

constarrays
    : CONST TYPE IDENT '[]' ':=' '{' VALUE (',' VALUE)* '}' ';'
    ;

vars
   : VAR TYPE IDENT ( '[' NUMBER ']' )? ( ',' IDENT ( '[' NUMBER ']' )? )* ';'
   ;

statement
   : (assignstmt | callstmt | beginstmt | ifstmt | whilestmt | dowhilestmt | forstmt | ternarstmt | writestmt | readstmt)? ';'
   ;

assignstmt
   : IDENT ('[' NUMBER ']')? (':=' IDENT ('[' NUMBER ']')?)* ':=' expression
   ;

callstmt
   : CALL IDENT
   ;

beginstmt
   : BEGIN statement (statement)* END
   ;

ifstmt
   : IF condition THEN statement (ELSE statement)?
   ;

whilestmt
   : WHILE condition DO statement
   ;

dowhilestmt
    : DO statement WHILE condition
    ;

forstmt
    : FOR IDENT ':=' number_expression TO number_expression DO statement
    ;

ternarstmt
    : IDENT ':=' condition '?' expression ':' expression
    ;

writestmt
    : WRITE '(' string_expression ')'
    ;

readstmt
    : READ '(' IDENT ')'
    ;

condition
   : '('
        (
        (number_expression ( '<' | '<=' | '>' | '>=' ) number_expression)
        | (expression ( '=' | '!=' ) expression)
        | (bool_expression)
        )
     ')'
   ;

expression
    : (number_expression | bool_expression | string_expression)
    ;

bool_expression
    : ('!')? (BOOLEAN | IDENT) (('&&' | '||') bool_expression)*
    ;

string_expression
    : (IDENT | STRING_VALUE) ('+' (IDENT | STRING_VALUE))*
    ;

number_expression
   : ('+' | '-')? term (('+' | '-') term)*
   ;

term
   : factor (('*' | '/') factor)*
   ;

factor
   : NUMBER
   | IDENT
   | ('(' number_expression ')')
   ;

CALL
    : 'call'
    ;

PROCEDURE
    : 'procedure'
    ;

VAR
    : 'var'
    ;

THEN
    : 'then'
    ;

BEGIN
    : 'begin'
    ;

END
    : 'end'
    ;

ELSE
    : 'else'
    ;

WHILE
    : 'while'
    ;

DO
    : 'do'
    ;

FOR
    : 'for'
    ;

TO
    : 'to'
    ;

IF
    : 'if'
    ;

READ
    : 'read'
    ;

WRITE
    : 'write'
    ;

CONST
    : 'const'
    ;

TYPE
    : ('int' | 'bool' | 'string')
    ;

VALUE
    : (NUMBER | BOOLEAN | STRING_VALUE)
    ;

IDENT
    : LETTER (LETTER | NUMBER)*
    ;

STRING_VALUE
    : '"' (LETTER | NUMBER)* '"'
    ;

BOOLEAN
    : ('true' | 'false')
    ;

LETTER
    : [a-zA-Z]
    ;

NUMBER
    : [0-9]+
    ;

WS
   : [ \t\r\n] -> channel(HIDDEN)
   ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;