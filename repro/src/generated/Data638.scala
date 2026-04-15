package generated

final case class Data638(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data638 = copy(name = name.toUpperCase)
  def scale(k: Double): Data638 = copy(value = value * k)
  def addTag(t: String): Data638 = copy(tags = t :: tags)
  def put(k: String, v: String): Data638 = copy(meta = meta.updated(k, v))
  def merge(other: Data638): Data638 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data638 {
  given Ordering[Data638] = Ordering.by(_.id)
  def empty: Data638 = Data638(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data638 =
    Data638(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data638] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
