object Form1: TForm1
  Left = 192
  Top = 107
  Width = 352
  Height = 144
  Caption = #1047#1072#1076#1072#1085#1080#1077' 1'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -15
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 16
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 145
    Height = 105
    Caption = #1042#1093#1086#1076#1085#1099#1077' '#1076#1072#1085#1085#1099#1077': '
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 24
      Width = 70
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' X:'
    end
    object Label2: TLabel
      Left = 8
      Top = 48
      Width = 71
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' Y:'
    end
    object Label3: TLabel
      Left = 8
      Top = 72
      Width = 70
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' Z:'
    end
    object eX: TEdit
      Left = 88
      Top = 21
      Width = 41
      Height = 24
      TabOrder = 0
    end
    object eY: TEdit
      Left = 88
      Top = 48
      Width = 41
      Height = 24
      TabOrder = 1
    end
    object eZ: TEdit
      Left = 88
      Top = 72
      Width = 41
      Height = 24
      TabOrder = 2
    end
  end
  object GroupBox2: TGroupBox
    Left = 168
    Top = 8
    Width = 169
    Height = 105
    Caption = #1042#1099#1093#1086#1076#1085#1099#1077' '#1076#1072#1085#1085#1099#1077': '
    TabOrder = 1
    object lU: TLabel
      Left = 8
      Top = 24
      Width = 23
      Height = 16
      Caption = 'U = '
    end
    object Button1: TButton
      Left = 8
      Top = 72
      Width = 153
      Height = 25
      Caption = #1056#1072#1089#1089#1095#1080#1090#1072#1090#1100
      TabOrder = 0
      OnClick = Button1Click
    end
  end
end
