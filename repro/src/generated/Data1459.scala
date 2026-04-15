package generated

final case class Data1459(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1459 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1459 = copy(value = value * k)
  def addTag(t: String): Data1459 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1459 = copy(meta = meta.updated(k, v))
  def merge(other: Data1459): Data1459 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1459 {
  given Ordering[Data1459] = Ordering.by(_.id)
  def empty: Data1459 = Data1459(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1459 =
    Data1459(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1459] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
