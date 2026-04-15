package generated

final case class Data691(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data691 = copy(name = name.toUpperCase)
  def scale(k: Double): Data691 = copy(value = value * k)
  def addTag(t: String): Data691 = copy(tags = t :: tags)
  def put(k: String, v: String): Data691 = copy(meta = meta.updated(k, v))
  def merge(other: Data691): Data691 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data691 {
  given Ordering[Data691] = Ordering.by(_.id)
  def empty: Data691 = Data691(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data691 =
    Data691(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data691] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
