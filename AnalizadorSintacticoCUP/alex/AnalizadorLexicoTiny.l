package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%column
%class AnalizadorLexicoTiny
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}


Int = Int
Bool = Bool
False = False
True = True
Void = Void
List = List

new = new

if = if
else = else

for = for
while = while
repeat = repeat

switch = switch
break = break
case = case
default = default

typedef = typedef

Struct = Struct

valuefor = valuefor

show = show
read = read

const = const

return = return

letra  = ([A-Z]|[a-z])
identificador = {letra}({letra}|{digito})*

digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = ({digitoPositivo}{digito}*|0)
numeroEntero = [\+\-]?{parteEntera}

operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/
operadorMod = mod
operadorSum = sum
operadorProd = prod

operadorIgualdad = \==
operadorMayor = \>
operadorMenor = \<
operadorMayorIgual = \>\=
operadorMenorIgual = \<\=
operadorDistinto = \!\=

operadorAnd = \&&
operadorOr = \|\|
operadorNegacion = not

separador = [ \t\r\b\n]
parentesisApertura = \(
parentesisCierre = \)
corcheteApertura = \[
corcheteCierre = \]
llaveApertura = \{
llaveCierre = \}
coma  = ,
puntoYComa = ;
punto = \.
dosPuntos = \:
comentario = \/\/[^\n]* 
comentarioLargo = "/*" ~"*/"
igual = \=
ampersand = \&
flecha = \->


%%
{separador}               {}
{comentario}              {}
{comentarioLargo}         {}

{numeroEntero}            {return ops.unidadEnt();}

{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{operadorMod}             {return ops.unidadMod();}
{operadorSum}             {return ops.unidadSumLista();}
{operadorProd}            {return ops.unidadProdLista();}

{operadorMayor}           {return ops.unidadMayor();}
{operadorMenor}           {return ops.unidadMenor();}
{operadorMayorIgual}      {return ops.unidadMayorIgual();}
{operadorMenorIgual}      {return ops.unidadMenorIgual();}
{operadorDistinto}        {return ops.unidadDistinto();}
{operadorIgualdad}        {return ops.unidadIgualdad();}

{operadorAnd}             {return ops.unidadAnd();}
{operadorOr}              {return ops.unidadOr();}
{operadorNegacion}        {return ops.unidadNegacion();}

{ampersand}               {return ops.unidadAmpersand();}
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{puntoYComa}              {return ops.unidadPuntoYComa();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();}
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{llaveApertura}           {return ops.unidadLLAp();}
{llaveCierre}             {return ops.unidadLLCierre();}
{punto}                   {return ops.unidadPunto();}
{dosPuntos}               {return ops.unidadDosPuntos();}
{flecha}                  {return ops.unidadFlecha();}

{Int}		                  {return ops.unidadTipoInt();}
{Bool}                    {return ops.unidadTipoBool();}
{Void}                    {return ops.unidadTipoVoid();} 
{True}                    {return ops.unidadTrue();}
{False}                   {return ops.unidadFalse();}
{List}                    {return ops.unidadList();}

{while}                   {return ops.unidadWhile();}
{for}                     {return ops.unidadFor();}
{repeat}                  {return ops.unidadRepeat();}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{Struct}                  {return ops.unidadStruct();}
{switch}                  {return ops.unidadSwitch();}
{valuefor}                {return ops.unidadValueFor();}
{case}                    {return ops.unidadCase();}
{break}                   {return ops.unidadBreak();}
{default}                 {return ops.unidadDefault();}
{return}                  {return ops.unidadReturn();}
{show}                   {return ops.unidadShow();}
{read}                    {return ops.unidadRead();}
{typedef}                 {return ops.unidadTypedef();}
{new}                     {return ops.unidadNew();}
{const}                   {return ops.unidadConstante();}

{identificador}           {return ops.unidadId();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  