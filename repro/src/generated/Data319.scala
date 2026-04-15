package generated

final case class Data319(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data319 = copy(name = name.toUpperCase)
  def scale(k: Double): Data319 = copy(value = value * k)
  def addTag(t: String): Data319 = copy(tags = t :: tags)
  def put(k: String, v: String): Data319 = copy(meta = meta.updated(k, v))
  def merge(other: Data319): Data319 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data319 {
  given Ordering[Data319] = Ordering.by(_.id)
  def empty: Data319 = Data319(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data319 =
    Data319(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data319] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
