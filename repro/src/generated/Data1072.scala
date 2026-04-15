package generated

final case class Data1072(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1072 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1072 = copy(value = value * k)
  def addTag(t: String): Data1072 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1072 = copy(meta = meta.updated(k, v))
  def merge(other: Data1072): Data1072 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1072 {
  given Ordering[Data1072] = Ordering.by(_.id)
  def empty: Data1072 = Data1072(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1072 =
    Data1072(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1072] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
