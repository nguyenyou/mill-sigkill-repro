package generated

final case class Data1015(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1015 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1015 = copy(value = value * k)
  def addTag(t: String): Data1015 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1015 = copy(meta = meta.updated(k, v))
  def merge(other: Data1015): Data1015 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1015 {
  given Ordering[Data1015] = Ordering.by(_.id)
  def empty: Data1015 = Data1015(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1015 =
    Data1015(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1015] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
