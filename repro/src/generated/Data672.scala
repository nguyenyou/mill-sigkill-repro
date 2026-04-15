package generated

final case class Data672(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data672 = copy(name = name.toUpperCase)
  def scale(k: Double): Data672 = copy(value = value * k)
  def addTag(t: String): Data672 = copy(tags = t :: tags)
  def put(k: String, v: String): Data672 = copy(meta = meta.updated(k, v))
  def merge(other: Data672): Data672 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data672 {
  given Ordering[Data672] = Ordering.by(_.id)
  def empty: Data672 = Data672(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data672 =
    Data672(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data672] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
