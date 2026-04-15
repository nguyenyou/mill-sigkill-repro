package generated

final case class Data438(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data438 = copy(name = name.toUpperCase)
  def scale(k: Double): Data438 = copy(value = value * k)
  def addTag(t: String): Data438 = copy(tags = t :: tags)
  def put(k: String, v: String): Data438 = copy(meta = meta.updated(k, v))
  def merge(other: Data438): Data438 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data438 {
  given Ordering[Data438] = Ordering.by(_.id)
  def empty: Data438 = Data438(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data438 =
    Data438(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data438] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
