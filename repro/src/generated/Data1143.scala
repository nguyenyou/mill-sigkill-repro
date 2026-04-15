package generated

final case class Data1143(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1143 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1143 = copy(value = value * k)
  def addTag(t: String): Data1143 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1143 = copy(meta = meta.updated(k, v))
  def merge(other: Data1143): Data1143 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1143 {
  given Ordering[Data1143] = Ordering.by(_.id)
  def empty: Data1143 = Data1143(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1143 =
    Data1143(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1143] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
