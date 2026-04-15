package generated

final case class Data572(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data572 = copy(name = name.toUpperCase)
  def scale(k: Double): Data572 = copy(value = value * k)
  def addTag(t: String): Data572 = copy(tags = t :: tags)
  def put(k: String, v: String): Data572 = copy(meta = meta.updated(k, v))
  def merge(other: Data572): Data572 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data572 {
  given Ordering[Data572] = Ordering.by(_.id)
  def empty: Data572 = Data572(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data572 =
    Data572(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data572] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
