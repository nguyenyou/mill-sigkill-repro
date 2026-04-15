package generated

final case class Data896(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data896 = copy(name = name.toUpperCase)
  def scale(k: Double): Data896 = copy(value = value * k)
  def addTag(t: String): Data896 = copy(tags = t :: tags)
  def put(k: String, v: String): Data896 = copy(meta = meta.updated(k, v))
  def merge(other: Data896): Data896 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data896 {
  given Ordering[Data896] = Ordering.by(_.id)
  def empty: Data896 = Data896(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data896 =
    Data896(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data896] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
