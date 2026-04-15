package generated

final case class Data431(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data431 = copy(name = name.toUpperCase)
  def scale(k: Double): Data431 = copy(value = value * k)
  def addTag(t: String): Data431 = copy(tags = t :: tags)
  def put(k: String, v: String): Data431 = copy(meta = meta.updated(k, v))
  def merge(other: Data431): Data431 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data431 {
  given Ordering[Data431] = Ordering.by(_.id)
  def empty: Data431 = Data431(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data431 =
    Data431(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data431] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
