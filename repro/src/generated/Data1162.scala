package generated

final case class Data1162(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1162 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1162 = copy(value = value * k)
  def addTag(t: String): Data1162 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1162 = copy(meta = meta.updated(k, v))
  def merge(other: Data1162): Data1162 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1162 {
  given Ordering[Data1162] = Ordering.by(_.id)
  def empty: Data1162 = Data1162(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1162 =
    Data1162(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1162] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
