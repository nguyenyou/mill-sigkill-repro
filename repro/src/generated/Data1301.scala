package generated

final case class Data1301(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1301 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1301 = copy(value = value * k)
  def addTag(t: String): Data1301 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1301 = copy(meta = meta.updated(k, v))
  def merge(other: Data1301): Data1301 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1301 {
  given Ordering[Data1301] = Ordering.by(_.id)
  def empty: Data1301 = Data1301(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1301 =
    Data1301(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1301] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
