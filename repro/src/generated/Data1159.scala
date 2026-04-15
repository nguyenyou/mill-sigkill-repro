package generated

final case class Data1159(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1159 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1159 = copy(value = value * k)
  def addTag(t: String): Data1159 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1159 = copy(meta = meta.updated(k, v))
  def merge(other: Data1159): Data1159 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1159 {
  given Ordering[Data1159] = Ordering.by(_.id)
  def empty: Data1159 = Data1159(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1159 =
    Data1159(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1159] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
