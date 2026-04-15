package generated

final case class Data587(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data587 = copy(name = name.toUpperCase)
  def scale(k: Double): Data587 = copy(value = value * k)
  def addTag(t: String): Data587 = copy(tags = t :: tags)
  def put(k: String, v: String): Data587 = copy(meta = meta.updated(k, v))
  def merge(other: Data587): Data587 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data587 {
  given Ordering[Data587] = Ordering.by(_.id)
  def empty: Data587 = Data587(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data587 =
    Data587(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data587] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
