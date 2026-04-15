package generated

final case class Data459(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data459 = copy(name = name.toUpperCase)
  def scale(k: Double): Data459 = copy(value = value * k)
  def addTag(t: String): Data459 = copy(tags = t :: tags)
  def put(k: String, v: String): Data459 = copy(meta = meta.updated(k, v))
  def merge(other: Data459): Data459 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data459 {
  given Ordering[Data459] = Ordering.by(_.id)
  def empty: Data459 = Data459(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data459 =
    Data459(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data459] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
