package generated

final case class Data358(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data358 = copy(name = name.toUpperCase)
  def scale(k: Double): Data358 = copy(value = value * k)
  def addTag(t: String): Data358 = copy(tags = t :: tags)
  def put(k: String, v: String): Data358 = copy(meta = meta.updated(k, v))
  def merge(other: Data358): Data358 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data358 {
  given Ordering[Data358] = Ordering.by(_.id)
  def empty: Data358 = Data358(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data358 =
    Data358(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data358] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
