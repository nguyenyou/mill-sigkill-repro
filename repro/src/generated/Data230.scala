package generated

final case class Data230(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data230 = copy(name = name.toUpperCase)
  def scale(k: Double): Data230 = copy(value = value * k)
  def addTag(t: String): Data230 = copy(tags = t :: tags)
  def put(k: String, v: String): Data230 = copy(meta = meta.updated(k, v))
  def merge(other: Data230): Data230 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data230 {
  given Ordering[Data230] = Ordering.by(_.id)
  def empty: Data230 = Data230(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data230 =
    Data230(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data230] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
