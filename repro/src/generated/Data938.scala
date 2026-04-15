package generated

final case class Data938(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data938 = copy(name = name.toUpperCase)
  def scale(k: Double): Data938 = copy(value = value * k)
  def addTag(t: String): Data938 = copy(tags = t :: tags)
  def put(k: String, v: String): Data938 = copy(meta = meta.updated(k, v))
  def merge(other: Data938): Data938 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data938 {
  given Ordering[Data938] = Ordering.by(_.id)
  def empty: Data938 = Data938(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data938 =
    Data938(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data938] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
